package com.example.kxz_android.ui.config

import android.content.Context
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
import androidx.compose.ui.draw.clip
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
val spaceCardMarginBigTB = 27.dp
val spaceCardMarginTB = 40.5.dp //上下外边距
val spaceCardPaddingTB = 56.25.dp //上下内边距
val spaceCardMarginRL = 27.dp //左右外边距
val spaceCardPaddingRL = 45.dp;//左右内边距

//字体大小管理
val fontSizeTitle50 = 19.sp //headline1
val fontSizeTitle45 = 18.sp //headline2
val fontSizeMain40 = 40.sp //body1
val fontSizeMini38 = 15.3.sp //body2
val fontSizeTip40 = 40.sp //subtitle1
val fontSizeTip33 = 36.sp //subtitle1
val fontSizeTipMini25 = 26.sp //subtitle2
val fontSizeTipMini20 = 30.sp //subtitle3

val sizeIconMain50 = 45.dp //图标大小管理

@Composable
fun FlyText(
    text: String, maxLines: Int = Int.MAX_VALUE,
    color: Color= Color.Black,
    fontSize:TextUnit,
    letterSpacing: Dp? = 0.dp,
    fontWeight: FontWeight? = null,
    modifier: Modifier=Modifier,
    textDecoration: androidx.compose.ui.text.style.TextDecoration? = null,
    textAlign: androidx.compose.ui.text.style.TextAlign? = null,
) {
    Text(
        text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        textDecoration = textDecoration,
        textAlign = textAlign,
        modifier = modifier.padding(start = letterSpacing ?: 0.dp,),
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
                .size(4.dp, 25.dp)
                .background(Color(0xFF33CC99), shape = CircleShape) // 设置圆角形状
                .border(4.dp, Color(0xFF33CC99), shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(20.dp))
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

@Composable
fun Int.nsp():TextUnit {
    return getRealDp(LocalContext.current,this.toDouble()).sp
}

@Composable
fun Float.nsp():TextUnit {
    return getRealDp(LocalContext.current,this.toDouble()).sp
}

@Composable
fun Double.nsp():TextUnit {
    return getRealDp(LocalContext.current,this).sp
}

private fun getRealDp(context: Context, value:Double):Double {
    val density= context.resources.displayMetrics.scaledDensity
    val screenWidth=context.resources.displayMetrics.widthPixels
    return ((screenWidth/750.0)*2*value/density)
}

