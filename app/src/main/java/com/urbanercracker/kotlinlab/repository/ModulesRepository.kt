package com.urbanercracker.kotlinlab.repository

import com.urbanercracker.kotlinlab.core.network.ApiResponse
import com.urbanercracker.kotlinlab.model.dto.ModuloDTO
import com.urbanercracker.kotlinlab.services.ModuleService
import javax.inject.Inject

class ModulesRepository @Inject constructor(
    private val moduleService: ModuleService
){
    suspend fun getAllModules(): ApiResponse<List<ModuloDTO>>{
        return moduleService.getAllModules()
    }

    suspend fun getSizeModules(): Int{
        val data = moduleService.getAllModules().data
        return if (data.isNullOrEmpty()) {
            0
        }else{
            data.count()
        }
    }
}