package com.urbanercracker.kotlinlab.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalColors = staticCompositionLocalOf { LightColors }

/** Acceso a la paleta desde cualquier pantalla: KotlinLabTema.colores.completadoFondo */
object ColorsApp {
    val colors: ColorsKotlinLab
        @Composable @ReadOnlyComposable
        get() = LocalColors.current
}

/**
 * Envuelve toda la app (en MainActivity, dentro de setContent).
 * Sigue el modo del teléfono: si el usuario activa el tema oscuro en Ajustes del sistema,
 * la app cambia de colores sola.
 */
@Composable
fun KotlinLabTheme(content: @Composable () -> Unit) {
    val oscuro = isSystemInDarkTheme()   // true si el teléfono está en modo oscuro
    val colors = if (oscuro) DarkColors else LightColors
    CompositionLocalProvider(LocalColors provides colors) {
        MaterialTheme(colorScheme = colors.aMaterial(oscuro), content = content)
    }
}

/**
 * Traduce la paleta a los roles de Material 3, para que los componentes que no
 * personalizas (Card, TextField, Switch, Dialog...) ya salgan con los colores del diseño.
 */
private fun ColorsKotlinLab.aMaterial(oscuro: Boolean): ColorScheme {
    val base = if (oscuro) darkColorScheme() else lightColorScheme()
    return base.copy(
        primary = primario,
        onPrimary = sobrePrimario,
        primaryContainer = primarioContenedor,
        onPrimaryContainer = sobrePrimarioContenedor,
        inversePrimary = destacada,
        secondary = completado,
        onSecondary = sobreCompletado,
        secondaryContainer = completadoFondo,
        onSecondaryContainer = sobreCompletadoFondo,
        tertiary = reto,
        onTertiary = sobreReto,
        tertiaryContainer = reto,
        onTertiaryContainer = sobreReto,
        background = fondo,
        onBackground = titulo,
        surface = superficie,
        onSurface = texto,
        surfaceVariant = superficieSuave,
        onSurfaceVariant = textoSecundario,
        surfaceTint = primario,
        surfaceBright = superficie,
        surfaceDim = fondo,
        surfaceContainerLowest = superficie,
        surfaceContainerLow = superficie,
        surfaceContainer = superficie,
        surfaceContainerHigh = superficieSuave,
        surfaceContainerHighest = superficie,   // Card() por defecto queda como en el diseño
        outline = borde,
        outlineVariant = borde,
        error = error,
        onError = sobreError,
        errorContainer = errorFondo,
        onErrorContainer = sobreErrorFondo,
        scrim = velo,
    )
}