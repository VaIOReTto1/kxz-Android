package com.example.kxz_android.person_page.electricity

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val BackgroundColor = Color(0xffe1e5e8)
private val TextColor = Color(0xff0abea5)
private val SecondaryTextColor = Color(0xffe1e5e8)
private val IconButtonSize = 28.dp

@Composable
fun ElectricityPage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(BackgroundColor)
    ) {
        PageHeader()
        Spacer(modifier = Modifier.height(50.dp))
        ElectricityCircle(electricity = 250)
        Text(text = "未绑定", color = TextColor, modifier = Modifier.padding(top = 25.dp))
        MessageTable()
        Recharge()
    }
}

@Composable
fun PageHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier.padding(start = 4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "close page",
                modifier = Modifier.size(IconButtonSize)
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "宿舍电量（需内网或VPN）",
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun ElectricityCircle(electricity: Int) {
    val percentage = if (electricity <= 360) electricity else 360

    Box(
        modifier = Modifier
            .size(130.dp)
            .background(Color.Transparent)
            .padding(4.dp)
    ) {
        // 画灰色圆环
        Canvas(
            modifier = Modifier.matchParentSize(),
            onDraw = {
                val centerX = size.width / 2
                val centerY = size.height / 2
                val radius = size.minDimension / 2

                drawCircle(
                    color = Color(0xffe0e1e5),
                    center = Offset(centerX, centerY),
                    radius = radius,
                    style = Stroke(50f) // 设置环的宽度
                )

                // 画绿色电力部分
                val startAngle = 90f // 从最下方开始
                val sweepAngle = (percentage.toFloat() / 360f) * 360f // 计算扫描角度

                drawArc(
                    color = Color(0xff0abea5),
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false, // 不使用圆心，使中间为空
                    topLeft = Offset(centerX - radius, centerY - radius),
                    size = Size(radius * 2, radius * 2),
                    style = Stroke(50f) // 设置环的宽度
                )
            }
        )

        // 放置图标
        val iconSize = 32.dp // 图标大小
        val iconOffsetX = (130.dp - iconSize - 7.dp) / 2
        val iconOffsetY = (130.dp - iconSize - 5.dp) / 2

        // 使用 Icons.Default.Add 图标，你可以替换为其他图标
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Electric Icon", // 可以设置一个描述
            modifier = Modifier.offset(x = iconOffsetX, y = iconOffsetY)
                .size(iconSize)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageTable() {
    Column(
        modifier = Modifier
            .padding(top = 30.dp, start = 16.dp, end = 16.dp)
            .height(250.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(8.dp)) // 设置圆角
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize().padding(start = 16.dp, top = 16.dp, end = 16.dp)
        ) {
            Text(text = "绑定信息", color = SecondaryTextColor)
            Divider(
                color = Color(0xffe1e5e8), // 设置横线颜色
                modifier = Modifier
                    .padding(top = 8.dp) // 调整横线与文本之间的间距
                    .fillMaxWidth(), // 让横线占满宽度
                thickness = 0.3.dp
            )
            Dormitory()
            RoomId()
            Box(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 15.dp)
                    .fillMaxWidth()
                    .height(45.dp)
                    .clip(RoundedCornerShape(8.dp)) // 先应用 clip
                    .background(color = Color(0xff0abea5)) // 再应用 background
                    .clickable(interactionSource = remember { MutableInteractionSource() },
                        indication = null, onClick = {}),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "绑定&刷新", color = Color.White)
            }
        }
    }
}

@Composable
@ExperimentalMaterial3Api
fun Dormitory() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("未选择") }

    val items = listOf("兰梅", "松竹", "桃苑", "杏苑")
    Row(
        modifier = Modifier
            .padding(top = 30.dp, bottom = 15.dp, end = 10.dp)
    ) {
        Text(text = "宿舍楼")
        Box(
            modifier = Modifier
                .clickable(interactionSource = remember { MutableInteractionSource() },
                    indication = null, onClick = { expanded = true }),
        ) {
            Row {
                Spacer(modifier = Modifier.weight(1f))
                Text(text = selectedOption, color = SecondaryTextColor)
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "select room",
                    modifier = Modifier.padding(start = 7.dp),
                    tint = Color(0xffe1e5e8)
                )
            }
        }
    }
    if (expanded) {
        ModalBottomSheet(
            onDismissRequest = { expanded = false },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(text = "选择宿舍楼")
                    Divider(
                        modifier = Modifier
                            .padding(top = 8.dp) // 调整横线与文本之间的间距
                            .fillMaxWidth(), // 让横线占满宽度
                        thickness = 1.dp
                    )
                    items.forEach { item ->
                        Text(
                            text = item,
                            modifier = Modifier
                                .clickable {
                                    selectedOption = item
                                    expanded = false
                                }
                                .padding(8.dp)
                        )
                    }
                }
            }
        )
    }
}

@Composable
fun RoomId(){
    var textValue by remember { mutableStateOf("输入大寝室号(如M2B319)") }
    var cursorPosition by remember { mutableStateOf(0) }
    Row(
        modifier = Modifier
            .padding(top = 15.dp, bottom = 15.dp, end = 10.dp)
    ) {
        Text(
            text = "大寝号",
        )
        Box(
            modifier = Modifier
                .clickable(interactionSource = remember { MutableInteractionSource() },
                    indication = null, onClick = {}),
        ) {
            Row {
                Spacer(modifier = Modifier.weight(1f)) // 使用 Spacer 将按钮推到右侧
                BasicTextField(
                    value = textValue,
                    onValueChange = { textValue = it.replace("输入大寝室号(如M2B319)", "")},
                    textStyle = TextStyle(color = SecondaryTextColor),
                    visualTransformation = VisualTransformation.None ,// 禁用可视化转换
                    )
            }
        }
    }
}

@Composable
fun Recharge() {
    Column(
        modifier = Modifier
            .padding(top = 10.dp, start = 16.dp, end = 16.dp)
            .height(130.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(8.dp)) // 设置圆角
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize().padding(start = 16.dp, top = 16.dp, end = 16.dp)
        ) {
            Text(text = "充值", color = SecondaryTextColor)
            Divider(
                color = Color(0xffe1e5e8), // 设置横线颜色
                modifier = Modifier
                    .padding(top = 8.dp) // 调整横线与文本之间的间距
                    .fillMaxWidth(), // 让横线占满宽度
                thickness = 0.3.dp
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(top = 10.dp)
                    .clickable(interactionSource = remember { MutableInteractionSource() },
                        indication = null, onClick = {})
                    .border(2.dp, Color(0xff0abea5), shape = RoundedCornerShape(8.dp))
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "前往充值", color = Color(0xff0abea5))
            }
        }
    }
}

@Preview
@Composable
fun ElectricityCirclePreview() {
    RoomId()
}

