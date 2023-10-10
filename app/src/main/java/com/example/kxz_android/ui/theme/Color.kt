package com.example.kxz_android.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.unit.dp

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


val Transparent = Color(0x00000000)

val themeColor = Color(0xFF92E2c7)

val white = Color(0xFFFFFFFF)
val white3 = Color(0xFFAE5E5E)

val black = Color(0xFF000000)

val statusBarColorLight = Color(0xFFFFFFFF)
val statusBarColorDark = Color(0xFF1C1C28)

val backgroundColorLight = Color(0xFFF2F5F9)
val backgroundColorDark = Color(0xFF1C1C28)
val backgroundSecondaryColorLight = Color(0xFFfbfcfd)
val backgroundSecondaryColorDark = Color(0xFF494953)
val themeBackground = Color(0xFFE7F2F1)
val whiteBackgroundColorLight = Color(0xFFFFFFFF)
val whiteBackgroundColorDark = Color(0xFF1C1C28)

val dialogBackgroundLight = Color(0xFFFEFEFE)
val dialogBackgroundDark = Color(0xFF2F323D)

val editBackgroundLight = Color(0xFFF2F3F8)
val editBackgroundDark = Color(0xFF707077)

val immerseBackgroundColorLight = Color(0xFFF2F3F8)
val immerseBackgroundColorDark = Color(0xFF0e0e14)

val itemBackgroundLight = Color(0xFFFFFFFF)
val itemBackgroundDark = Color(0xFFF33333D)

val textPrimaryLight = Color(0xFF333333)
val textPrimaryDark = Color(0xFFE8E8F0)

val textSecondaryLight = Color(0xFF999999)
val textSecondaryDark = Color(0xFFD5D5D5)

val textWhite = Color(0xFFFFFFFF)
val textBlack = Color(0xFF333333)

val blue = Color(0xFF51BDFF)
val blueLightAccent = Color(0xFFD0E7F8)

val blueDark = Color(0xFF2aa0fe)
val blueDarkAccent = Color(0xFF224B6F)

val red = Color(0xFFFF5500)
val red2 = Color(0xFFDD302E)
val green = Color(0xFF68be8d)
val grey = Color(0xFF888888)
val grey1 = Color(0xFF888888)
val themeAccentColor = Color(0xFFE7FBF7)


object AppColor {
    val blue = Color(0xFF51BDFF).convert(ColorSpaces.CieXyz)
    val red = Color(0xFFFF5500).convert(ColorSpaces.CieXyz)
    val themeAccent = Color(0xFFe9f9f4).convert(ColorSpaces.CieXyz)
    val themeColor = Color(0xFF92E2c7).convert(ColorSpaces.CieXyz)
    val warning = Color(0xFFDF7B00).convert(ColorSpaces.CieXyz)
}
// 色彩管理
var colorMain: Color = Color(0xff00c5a8)
var colorSecond: Color = Color(0xFF33CC99)
var colorMainText: Color = Color.Black
var colorMainTextWhite: Color = Color.White
var colorIconBackground: Color = Color(0xFFF4F5F9)
var colorShadow: Color = Color(0xFFCCCCCC)
var scaffoldBackgroundColor: Color = Color.White
var colorPageBackground: Color = Color(0xFFF7F7F7)
var colorLoginPageMain: Color = Color(0xFF28D8A1)

val colorLessonCard: List<Color> = listOf(
    Color(0xFF66CC99),
    Color(0xFF6699FF),
    Color(0xFFFF9999),
    Color(0xFFA691F8),
    Color(0xFF3EBCCA),
    Color(0xFFFF9966),
    Color(0xFF4ECCCC),
    Color(0xFFFF9BCB)
)

val colorFuncButton: List<Color> = listOf(
    Color(0xFF58BCD8),
    Color(0xFFEE79C0),
    Color(0xFF7D7BE3),
    Color(0xFF5DA9F8),
    Color(0xFF5A8AEA),
    Color(0xFF52AC62),
    Color(0xFFE56948)
)

val colorExamCard: List<Color> = listOf(
    Color.Red,
    Color(0xFFFF6F40),
    Color.Blue,
    Color.Green,
    Color(0xFFBFBCB7)
)

val borderRadiusValue = 10.dp //容器圆角值

//阴影
val boxShadowMain = Shadow(
    color = Color.Black.copy(alpha = 0.1f),
    offset = Offset(0f, 10f),
    blurRadius = 10f
)
