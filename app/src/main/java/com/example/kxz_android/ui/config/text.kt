package com.example.kxz_android.ui.config

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun Screen(text: String) {
    val fontScale = LocalDensity.current.fontScale
    val displayMetrics = LocalContext.current.resources.displayMetrics
    val widthPixels = displayMetrics.widthPixels
    MaterialTheme(
        content = {
            CompositionLocalProvider(
                LocalDensity provides Density(
                    density = widthPixels / 360.0f,
                    fontScale = fontScale
                )
            ) {}
        }
    )
}

//边距等配置
val spaceCardMarginBigTB = 30.dp
val spaceCardMarginTB = 25.dp //上下外边距
val spaceCardPaddingTB = 25.dp //上下内边距
val spaceCardMarginRL = 30.dp //左右外边距
val spaceCardPaddingRL = 50.dp;//左右内边距

//字体大小管理
val fontSizeTitle50 = 50.sp //headline1
val fontSizeTitle45 = 45.sp //headline2
val fontSizeMain40 = 40.sp //body1
val fontSizeMini38 = 38.sp //body2
val fontSizeTip33 = 33.sp //subtitle1
val fontSizeTipMini25 = 25.sp //subtitle2
val fontSizeTipMini20 = 30.sp //subtitle3

val sizeIconMain50 = 50.dp //图标大小管理

fun FlyText(
    text: String, maxLines: Int = Int.MAX_VALUE,
    color: Color = Color.Unspecified,
    fontSize:TextUnit,
    letterSpacing: Dp? = 0.dp,
    fontWeight: FontWeight? = null,
    textDecoration: androidx.compose.ui.text.style.TextDecoration? = null,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null,
) {
    Text(
        text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        textDecoration = textDecoration,
        textAlign = textAlign,
        modifier = Modifier.padding(start = letterSpacing ?: 0.dp,),
        color = color,
        maxLines=maxLines,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun FlyTip(
    text: String, maxLines: Int = Int.MAX_VALUE,
    color: Color = Color(0xff8d8d93),
    fontSize:TextUnit,
    letterSpacing: Dp? = 0.dp,
    fontWeight: FontWeight? = null,
    textDecoration: androidx.compose.ui.text.style.TextDecoration? = null,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null,
) {
    Text(
        text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        textDecoration = textDecoration,
        textAlign = textAlign,
        modifier = Modifier.padding(start = letterSpacing ?: 0.dp,),
        color = color,
        maxLines=maxLines,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun FlyTitle(title: String, textColor: Color = Color.Black) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(8.dp, 45.dp)
                .background(Color.Black)
                .border(1.dp, Color.Black, CircleShape)
        )
        Spacer(modifier = Modifier.width(35.dp))
        Text(
            text = title,
            style = TextStyle(
                fontSize = fontSizeTitle45,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        )
    }
}

