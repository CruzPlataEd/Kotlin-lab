package com.urbanercracker.kotlinlab.services

import com.urbanercracker.kotlinlab.core.di.dataJson.AllDataClient
import com.urbanercracker.kotlinlab.core.network.ApiResponse
import com.urbanercracker.kotlinlab.model.dto.ModuloDTO
import javax.inject.Inject

class ModuleService @Inject constructor(private val client: AllDataClient) {

    suspend fun getModulos(): ApiResponse<List<ModuloDTO>> {
        return try {
            ApiResponse(true, "OK", 200, client.getAllData().modulos.sortedBy { it.numero })
        } catch (e: Exception) {
            ApiResponse(false, "Ocurrió un error al cargar los módulos: $e", 500, null)
        }
    }

    suspend fun getModulo(idModulo: String): ApiResponse<ModuloDTO> {
        return try {
            val dato = client.getCursoCompleto().modulos.firstOrNull { it.id == idModulo }
            if (dato != null) {
                ApiResponse(true, "OK", 200, dato)
            } else {
                ApiResponse(false, "No se encontró el módulo.", 404, null)
            }
        } catch (e: Exception) {
            ApiResponse(false, "Ocurrió un error al cargar el módulo: $e", 500, null)
        }
    }

    suspend fun getModulosPorNivel(idNivel: String): ApiResponse<List<ModuloDTO>> {
        return try {
            ApiResponse(true, "OK", 200, client.getCursoCompleto().modulos.filter { it.nivel == idNivel })
        } catch (e: Exception) {
            ApiResponse(false, "Ocurrió un error al cargar los módulos del nivel: $e", 500, null)
        }
    }

    suspend fun getPruebaRapida(idModulo: String): ApiResponse<PruebaRapidaDTO> {
        return try {
            val dato = client.getCursoCompleto().modulos.firstOrNull { it.id == idModulo }?.pruebaRapida
            if (dato != null) {
                ApiResponse(true, "OK", 200, dato)
            } else {
                ApiResponse(false, "No se encontró la prueba rápida.", 404, null)
            }
        } catch (e: Exception) {
            ApiResponse(false, "Ocurrió un error al cargar la prueba rápida: $e", 500, null)
        }
    }
}
