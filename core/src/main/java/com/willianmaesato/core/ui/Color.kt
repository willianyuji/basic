package com.willianmaesato.core.ui

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import com.willianmaesato.core.BuildConfig

@Suppress("PropertyName")
interface ColorsPalette {
    val ColorPrimary: Color
    val ColorPrimaryVariant: Color

    val ColorSecondary: Color
    val ColorSecondaryVariant: Color

    val ColorAccent: Color
    val ColorAccentVariant: Color

    val ColorBackground: Color
    val ColorSurface: Color

    val ColorError: Color
    val ColorOnError: Color

    val ColorOnPrimary: Color
    val ColorOnSecondary: Color
    val ColorOnSurface: Color
    val ColorOnBackground: Color
}

object FlavorFree : ColorsPalette {
    override val ColorPrimary = Color(0xFF66A558)
    override val ColorPrimaryVariant = Color(0xFF408335)

    override val ColorSecondary = Color(0xFF83CACA)
    override val ColorSecondaryVariant = Color(0xFF00A099)

    override val ColorAccent= Color(0xFFB80065)
    override val ColorAccentVariant= Color(0xFFEE7BAE)

    override val ColorBackground = Color(0xFFF0F0F0)
    override val ColorSurface = Color(0xFFFFFFFF)

    override val ColorError = Color(0xFFC50014)
    override val ColorOnError = Color(0xFFFFFFFF)

    override val ColorOnPrimary = Color(0xFFFFFFFF)
    override val ColorOnSecondary = Color(0xFF3A3A3A)
    override val ColorOnSurface = Color(0xFF282D37)
    override val ColorOnBackground = Color(0xFF282D37)


}

object FlavorPaid: ColorsPalette {
    override val ColorPrimary = Color(0xFF66A558)
    override val ColorPrimaryVariant = Color(0xFF408335)

    override val ColorSecondary = Color(0xFF83CACA)
    override val ColorSecondaryVariant = Color(0xFF00A099)

    override val ColorAccent= Color(0xFFFFD800)
    override val ColorAccentVariant= Color(0xFF73AEF4)

    override val ColorBackground = Color(0xFF282D37)
    override val ColorSurface = Color(0xFF3C414B)

    override val ColorError = Color(0xFFEC0016)
    override val ColorOnError = Color(0xFFFFFFFF)

    override val ColorOnPrimary = Color(0xFFFFFFFF)
    override val ColorOnSecondary = Color(0xFFFFFFFF)
    override val ColorOnSurface = Color(0xFFFFFFFF)
    override val ColorOnBackground = Color(0xFFFFFFFF)
}

fun getColors(
    flavor: String = BuildConfig.FLAVOR,
    darkTheme: Boolean = false
): Colors {
    val colorsPalette: ColorsPalette =
        when {
            flavor.contains("free") -> FlavorFree
            flavor.contains("paid") -> FlavorPaid
            else -> FlavorFree
        }

    return Colors(
        primary = colorsPalette.ColorPrimary,
        primaryVariant = colorsPalette.ColorPrimaryVariant,
        secondary = colorsPalette.ColorSecondary,
        secondaryVariant = colorsPalette.ColorSecondaryVariant,
        background = colorsPalette.ColorBackground,
        surface = colorsPalette.ColorSurface,
        error = colorsPalette.ColorError,
        onError = colorsPalette.ColorOnError,
        onPrimary = colorsPalette.ColorOnPrimary,
        onSecondary = colorsPalette.ColorOnSecondary,
        onSurface = colorsPalette.ColorOnSurface,
        onBackground = colorsPalette.ColorOnBackground,
        isLight = !darkTheme
    )
}
