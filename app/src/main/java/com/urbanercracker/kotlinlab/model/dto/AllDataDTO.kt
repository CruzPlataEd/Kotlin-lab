package com.urbanercracker.kotlinlab.model.dto

data class AllDataDTO(
    val version: String,
    val esquema: Int,
    val modulos: List<ModuloDTO>
)
    /*
    val curso: CursoDTO,
    val catalogos: CatalogosDTO,
    val modulos: List<ModuloDTO>,
    val ejercicios: List<EjercicioDTO>,
    val glosario: List<TerminoGlosarioDTO>,
    val recursos: List<RecursoDTO>*/
