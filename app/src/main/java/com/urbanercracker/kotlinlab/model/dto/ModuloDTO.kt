package com.urbanercracker.kotlinlab.model.dto

data class ModuloDTO(
    val id: String,
    val numero: Int,
    val nombre: String,
    val nivel: String,
    val duracionHoras: Double,
    val objetivo: String,
    val nombreCorto: String
)