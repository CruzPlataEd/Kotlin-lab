package com.urbanercracker.kotlinlab.core.di.dataJson

import android.content.Context
import com.google.gson.Gson
import com.urbanercracker.kotlinlab.model.dto.AllDataDTO
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Fuente de datos local que obtiene el contenido del curso desde un archivo JSON
 * incluido en la carpeta `assets` de la aplicación.
 *
 * El archivo se lee una sola vez: después de la primera lectura, el resultado se
 * guarda en memoria y las siguientes llamadas lo devuelven sin volver a acceder al disco.
 *
 * Es un [Singleton] administrado por Hilt, por lo que toda la aplicación comparte
 * la misma instancia y el mismo caché.
 *
 * @param context Contexto de la aplicación, usado para acceder a los assets.
 * Se usa el de la aplicación (y no el de una Activity) para evitar fugas de memoria.
 * @param gson Instancia de [Gson] que convierte el JSON en objetos de Kotlin.
 *
 * @see AllDataClient
 * @see AllDataDTO
 */
@Singleton
class AssetLocalData @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson
) : AllDataClient {

    /**
     * Evita que varias corrutinas lean el archivo al mismo tiempo.
     * Si dos llamadas llegan juntas, la segunda espera y reutiliza el resultado de la primera.
     */
    private val mutex = Mutex()
    private var cache: AllDataDTO? = null

    /**
     * Devuelve todos los datos del curso.
     *
     * La primera llamada lee [NAME_ASSET] desde los assets; las siguientes
     * devuelven la copia guardada en memoria.
     *
     * @return Los datos del curso como [AllDataDTO].
     */
    override suspend fun getAllData(): AllDataDTO {
        return mutex.withLock {
            cache ?: readFile().also { cache = it }
        }
    }

    /**
     * Lee [NAME_ASSET] y lo convierte en un [AllDataDTO].
     *
     * La lectura se hace en [Dispatchers.IO] para no bloquear el hilo principal.
     * El archivo se cierra automáticamente al terminar, aunque ocurra un error.
     *
     * @return El contenido del archivo convertido a [AllDataDTO].
     */
    private suspend fun readFile(): AllDataDTO {
        return withContext(Dispatchers.IO) {
            context.assets.open(NAME_ASSET).bufferedReader().use { reader ->
                gson.fromJson(reader, AllDataDTO::class.java)
            }
        }
    }

    companion object {
        const val NAME_ASSET = "kotlin_curso.json"
    }
}