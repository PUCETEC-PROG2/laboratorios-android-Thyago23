package ec.edu.puce.githubclient.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = CarbonDeepDark,
    surface = CarbonMedium,
    onPrimary = WhitePure,
    onSecondary = WhitePure,
    onBackground = WhiteBase,
    onSurface = WhiteBase
)

// Configuración exacta para tu pantalla (Modo Claro Premium)
private val LightColorScheme = lightColorScheme(
    primary = Purple40,             // ROJO (Asignado al título/iconos de la barra)
    secondary = PurpleGrey40,       // NEGRO (Asignado al fondo del botón Guardar)
    tertiary = Pink40,

    background = WhitePure,         // Fondo general de la pantalla (Blanco Puro)
    surface = WhitePure,            // Fondo de la barra superior (TopAppBar) cambiado a Blanco

    onPrimary = WhitePure,
    onSecondary = WhitePure,        // Texto Blanco dentro del botón Negro
    onBackground = CarbonDeepDark,  // Texto oscuro para los títulos de los inputs
    onSurface = CarbonDeepDark,     // Texto digitado dentro de los campos
    onSurfaceVariant = CarbonTextGray // Color gris de los placeholders ("Nombre del repositorio")
)

@Composable
fun GithubClientTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Desactivado para que use estrictamente tu diseño GT3 RS
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}