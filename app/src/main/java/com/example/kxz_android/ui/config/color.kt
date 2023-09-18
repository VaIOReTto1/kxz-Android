package com.example.kxz_android.ui.config

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.unit.dp

// 设备尺寸
val deviceWidth: Int = 0 // 请根据实际情况设置
val deviceHeight: Int = 0 // 请根据实际情况设置

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
