package com.urbanercracker.kotlinlab.core.di.dataJson

import com.urbanercracker.kotlinlab.model.dto.AllDataDTO

interface AllDataClient {
    suspend fun getAllData(): AllDataDTO
}