package com.urbanercracker.kotlinlab.services

import com.urbanercracker.kotlinlab.core.di.dataJson.AllDataClient
import com.urbanercracker.kotlinlab.core.network.ApiResponse
import com.urbanercracker.kotlinlab.model.dto.ModuloDTO
import javax.inject.Inject

class ModuleService @Inject constructor(private val client: AllDataClient) {
    suspend fun getAllModules(): ApiResponse<List<ModuloDTO>> {
        return try {
            ApiResponse(true, "OK", 200, client.getAllData().modulos.sortedBy { it.numero })
        } catch (e: Exception) {
            ApiResponse(false, "Ocurrió un error al cargar los módulos: $e", 500, null)
        }
    }
}
