package com.urbanercracker.kotlinlab.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

// Paleta de Kotlin Lab, en modo claro y oscuro.
//
// Las pantallas nunca usan un color "a mano": piden el rol (fondo, título, completado...)
// con KotlinLabTema.colores.<rol>. Así el modo oscuro funciona solo.
//
// Reglas del diseño:
//   · Verde = ya lo hiciste (completado, leída, resuelto, parte llena de las barras).
//   · Azul  = acciones y lo que falta.
//   · Azul marino = nivel Reto y proyecto final.
//   · Rojo  = solo errores de las pruebas del código.
// Todos los pares texto/fondo cumplen contraste 4.5:1 o más en los dos modos.

@Immutable
data class ColorsKotlinLab(
    // ---------- Fondos y superficies ----------
    val fondo: Color,                    // fondo de toda la pantalla
    val superficie: Color,               // tarjetas, filas, campos de texto, barra inferior
    val superficieSuave: Color,          // fondo de pestañas segmentadas, bloques "Errores comunes"
    val borde: Color,                    // contorno de tarjetas, campos y divisores
    val bordePunteado: Color,            // borde punteado: "Ver pista", proyecto final, estado vacío

    // ---------- Texto ----------
    val titulo: Color,                   // títulos y texto principal sobre fondo
    val texto: Color,                    // párrafos sobre superficie
    val textoSecundario: Color,          // subtítulos grises, detalles, etiquetas
    val textoAyuda: Color,               // placeholder de campos
    val enlace: Color,                   // "Ver todo", "¿Olvidaste tu contraseña?"

    // ---------- Acción principal (botón azul) ----------
    val primario: Color,
    val sobrePrimario: Color,            // texto del botón y círculo de la flecha
    val primarioContenedor: Color,       // chips azul claro, círculo del botón secundario, íconos en cuadro
    val sobrePrimarioContenedor: Color,  // texto e íconos sobre primarioContenedor
    val primarioDeshabilitado: Color,    // "Comprobar" sin opción elegida

    // ---------- Tarjeta destacada (Inicio, cabecera del módulo, logo) ----------
    val destacada: Color,
    val sobreDestacada: Color,
    val sobreDestacadaSecundario: Color, // textos de apoyo sobre la tarjeta azul
    val destacadaTranslucida: Color,     // chips y botones de volver sobre la tarjeta azul, pista del anillo

    // ---------- Estado: COMPLETADO ----------
    val completado: Color,               // círculo con ✓, texto "Completado", cabecera de "Resuelto"
    val sobreCompletado: Color,          // la ✓ y el texto sobre completado
    val completadoFondo: Color,          // fondo de filas de módulos/ejercicios completados
    val sobreCompletadoFondo: Color,     // texto secundario dentro de una fila completada
    val completadoAnillo: Color,         // anillo de avance y barras sobre la tarjeta azul

    // ---------- Estado: FALTA ----------
    val faltaFondo: Color,               // fila de módulo/ejercicio que falta
    val faltaBorde: Color,
    val faltaIndicador: Color,           // círculo con el número del módulo
    val sobreFaltaIndicador: Color,      // número dentro del círculo

    // ---------- Barras de progreso ----------
    val barraLlena: Color,               // parte hecha (siempre verde)
    val barraVacia: Color,               // parte que falta

    // ---------- Dificultad (1, 2 o 3 barritas) ----------
    val dificultadActiva: Color,
    val dificultadInactiva: Color,

    // ---------- Reto y proyecto final ----------
    val reto: Color,
    val sobreReto: Color,
    val sobreRetoSecundario: Color,

    // ---------- Bloqueado (candado) ----------
    val bloqueadoFondo: Color,
    val sobreBloqueado: Color,

    // ---------- Error (solo pruebas del código) ----------
    val error: Color,
    val sobreError: Color,
    val errorFondo: Color,
    val sobreErrorFondo: Color,

    // ---------- Controles ----------
    val segmentadoFondo: Color,          // carril de Todos / Faltan / Completados
    val segmentadoActivo: Color,         // opción elegida
    val sobreSegmentadoActivo: Color,
    val interruptorEncendido: Color,
    val interruptorApagado: Color,
    val perilla: Color,                  // círculo que se mueve del interruptor
    val velo: Color,                     // oscurece la pantalla detrás de la hoja de Pistas

    // ---------- Barra de navegación inferior ----------
    val navFondo: Color,
    val navActivoFondo: Color,           // píldora detrás del ícono activo
    val navActivoContenido: Color,
    val navInactivo: Color,

    // ---------- Editor y bloques de código ----------
    val codigoFondo: Color,
    val codigoTexto: Color,
    val codigoPalabraClave: Color,       // val, fun, null, if...
    val codigoTextoLiteral: Color,       // "texto entre comillas"
    val codigoNumero: Color,
    val codigoComentario: Color,         // // comentarios y números de línea
    val codigoLineaError: Color,         // resalta la línea que falló
)

val LightColors = ColorsKotlinLab(
    fondo = Color(0xFFF4F8FB),
    superficie = Color(0xFFFFFFFF),
    superficieSuave = Color(0xFFE8F0F7),
    borde = Color(0xFFD5E1EC),
    bordePunteado = Color(0xFF7FA6EC),

    titulo = Color(0xFF0F1B2D),
    texto = Color(0xFF0F1B2D),
    textoSecundario = Color(0xFF4B5B70),
    textoAyuda = Color(0xFF66768A),
    enlace = Color(0xFF1F5FD6),

    primario = Color(0xFF1F5FD6),
    sobrePrimario = Color(0xFFFFFFFF),
    primarioContenedor = Color(0xFFDCE8FC),
    sobrePrimarioContenedor = Color(0xFF0B2E6E),
    primarioDeshabilitado = Color(0xFF9DB4DE),

    destacada = Color(0xFF1F5FD6),
    sobreDestacada = Color(0xFFFFFFFF),
    sobreDestacadaSecundario = Color(0xFFDCE8FC),
    destacadaTranslucida = Color(0x29FFFFFF),        // blanco al 16 %

    completado = Color(0xFF0F7A52),
    sobreCompletado = Color(0xFFFFFFFF),
    completadoFondo = Color(0xFFDDF3E8),
    sobreCompletadoFondo = Color(0xFF06402A),
    completadoAnillo = Color(0xFF7BE3B4),

    faltaFondo = Color(0xFFFFFFFF),
    faltaBorde = Color(0xFFD5E1EC),
    faltaIndicador = Color(0xFFDCE8FC),
    sobreFaltaIndicador = Color(0xFF0B2E6E),

    barraLlena = Color(0xFF18935B),
    barraVacia = Color(0xFFDCE8FC),

    dificultadActiva = Color(0xFF0B2E6E),
    dificultadInactiva = Color(0x380B2E6E),          // azul marino al 22 %

    reto = Color(0xFF0B2E6E),
    sobreReto = Color(0xFFFFFFFF),
    sobreRetoSecundario = Color(0xFFDCE8FC),

    bloqueadoFondo = Color(0xFFE8F0F7),
    sobreBloqueado = Color(0xFF4B5B70),

    error = Color(0xFFC2362B),
    sobreError = Color(0xFFFFFFFF),
    errorFondo = Color(0xFFFDE4E1),
    sobreErrorFondo = Color(0xFF7A1A12),

    segmentadoFondo = Color(0xFFE8F0F7),
    segmentadoActivo = Color(0xFF0F1B2D),
    sobreSegmentadoActivo = Color(0xFFFFFFFF),
    interruptorEncendido = Color(0xFF0F7A52),
    interruptorApagado = Color(0xFFB7C6D6),
    perilla = Color(0xFFFFFFFF),
    velo = Color(0x730F1B2D),                        // tinta al 45 %

    navFondo = Color(0xFFFFFFFF),
    navActivoFondo = Color(0xFFDCE8FC),
    navActivoContenido = Color(0xFF0B2E6E),
    navInactivo = Color(0xFF4B5B70),

    codigoFondo = Color(0xFF0F1B2D),
    codigoTexto = Color(0xFFE8EEF6),
    codigoPalabraClave = Color(0xFF7FB2FF),
    codigoTextoLiteral = Color(0xFF8EE3B5),
    codigoNumero = Color(0xFFFFC98A),
    codigoComentario = Color(0xFF8A9BB0),
    codigoLineaError = Color(0x47C2362B),            // rojo al 28 %
)

val DarkColors = ColorsKotlinLab(
    fondo = Color(0xFF0B1320),
    superficie = Color(0xFF131E2E),
    superficieSuave = Color(0xFF1B2839),
    borde = Color(0xFF2A3A4F),
    bordePunteado = Color(0xFF4C6EA8),

    titulo = Color(0xFFEEF3F9),
    texto = Color(0xFFE1E8F1),
    textoSecundario = Color(0xFFA7B4C4),
    textoAyuda = Color(0xFF8392A6),
    enlace = Color(0xFF8FB4FF),

    primario = Color(0xFF7FA8FF),
    sobrePrimario = Color(0xFF0A1D45),
    primarioContenedor = Color(0xFF1E3766),
    sobrePrimarioContenedor = Color(0xFFD4E3FF),
    primarioDeshabilitado = Color(0xFF34466A),

    destacada = Color(0xFF1D4CA8),
    sobreDestacada = Color(0xFFFFFFFF),
    sobreDestacadaSecundario = Color(0xFFD4E3FF),
    destacadaTranslucida = Color(0x29FFFFFF),

    completado = Color(0xFF4AD39A),
    sobreCompletado = Color(0xFF04291A),
    completadoFondo = Color(0xFF123527),
    sobreCompletadoFondo = Color(0xFFB9F0D6),
    completadoAnillo = Color(0xFF7BE3B4),

    faltaFondo = Color(0xFF131E2E),
    faltaBorde = Color(0xFF2A3A4F),
    faltaIndicador = Color(0xFF1E3766),
    sobreFaltaIndicador = Color(0xFFD4E3FF),

    barraLlena = Color(0xFF3CC98B),
    barraVacia = Color(0xFF1E3766),

    dificultadActiva = Color(0xFFD4E3FF),
    dificultadInactiva = Color(0x40D4E3FF),          // al 25 %

    reto = Color(0xFF1A2E5A),
    sobreReto = Color(0xFFFFFFFF),
    sobreRetoSecundario = Color(0xFFD4E3FF),

    bloqueadoFondo = Color(0xFF1B2839),
    sobreBloqueado = Color(0xFFA7B4C4),

    error = Color(0xFFFF8E80),
    sobreError = Color(0xFF3E1A17),
    errorFondo = Color(0xFF3E1A17),
    sobreErrorFondo = Color(0xFFFFD8D2),

    segmentadoFondo = Color(0xFF1B2839),
    segmentadoActivo = Color(0xFFE1E8F1),
    sobreSegmentadoActivo = Color(0xFF0B1320),
    interruptorEncendido = Color(0xFF3CC98B),
    interruptorApagado = Color(0xFF3A4A5E),
    perilla = Color(0xFFFFFFFF),
    velo = Color(0x99000000),                        // negro al 60 %

    navFondo = Color(0xFF131E2E),
    navActivoFondo = Color(0xFF1E3766),
    navActivoContenido = Color(0xFFD4E3FF),
    navInactivo = Color(0xFFA7B4C4),

    codigoFondo = Color(0xFF070E19),                 // más oscuro que el fondo, para que el bloque se note
    codigoTexto = Color(0xFFE8EEF6),
    codigoPalabraClave = Color(0xFF8FBBFF),
    codigoTextoLiteral = Color(0xFF8EE3B5),
    codigoNumero = Color(0xFFFFC98A),
    codigoComentario = Color(0xFF8A9BB0),
    codigoLineaError = Color(0x38FF8E80),            // al 22 %
)