package com.urbanercracker.kotlinlab.core.di.dataJson

import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Está instalado en [SingletonComponent], por lo que sus dependencias viven
 * mientras la aplicación esté abierta.
 */
@Module
@InstallIn(SingletonComponent::class)
object CourseModule {

    /**
     * Crea la instancia de [Gson] que se usa para convertir JSON en objetos de Kotlin.
     *
     * Al ser [Singleton], toda la aplicación comparte la misma instancia.
     * [Gson] es seguro para usarse desde varios hilos, así que compartirlo no causa problemas.
     *
     * @return Una instancia de [Gson] con la configuración por defecto.
     */
    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }
}

/**
 * Módulo de Hilt que asocia cada interfaz con la implementación que se usará en la app.
 *
 * Cuando una clase pida una interfaz en su constructor, Hilt entregará la
 * implementación indicada aquí. Para cambiar de implementación (por ejemplo,
 * de datos locales a un servidor) solo hay que modificar este módulo.
 *
 * Es una clase abstracta porque las funciones con `@Binds` no llevan cuerpo:
 * Hilt genera el código por nosotros.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class CourseBindsModule {

    /**
     * Indica que, cuando se pida un [AllDataClient], Hilt debe entregar [AssetLocalData].
     *
     * No lleva `@Singleton` porque [AssetLocalData] ya está marcada como singleton
     * en su propia clase.
     *
     * @param impl Implementación que lee los datos del curso desde los assets.
     * @return La misma instancia, expuesta como [AllDataClient].
     */
    @Binds
    abstract fun bindCourseLocalClient(impl: AssetLocalData): AllDataClient
}