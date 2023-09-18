package com.example.kxz_android.tablePage

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.example.kxz_android.R
import com.example.kxz_android.ui.theme.KxzAndroidTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageWithIndicator() {
    val pageState = rememberPagerState()
    val numPages = 22
    val indicatorModifier = Modifier
        .padding(top = 200.dp)
    var currentPage by remember { mutableStateOf(0) }

    Image(
        painter = painterResource(id = R.mipmap.background), // 替换为您的图片资源
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

    Row(
    ) {
        Column(modifier = Modifier.padding(top = 50.dp)) {
            CourseDayTime()
        }
        Column(modifier = Modifier.padding(top = 32.dp)) {
            CourseWeekTime()
            VerticalPager(
                state = pageState,
                modifier = Modifier.weight(1f).fillMaxSize(),
                pageCount = numPages
            ) {
                TablePage()
            }
        }
        // 翻页指示器
        Column(
            modifier = indicatorModifier,
        ) {
            for (page in 0 until numPages) {
                PageIndicator(
                    isSelected = currentPage == page,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }
        }
    }

    LaunchedEffect(pageState.currentPage) {
        currentPage = pageState.currentPage
    }
}

@Composable
fun PageIndicator(
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    val color = if (isSelected) Color(0xff6bc89b) else Color(0xff8596a0)
    Box(
        modifier = modifier
            .size(5.dp)
            .background(
                color = color,
                shape = CircleShape
            )
    )
}

@Composable
fun CourseDayTime() {
    val timeSlots = listOf(
        TimeSlot("1", "08:00", "08:50"),
        TimeSlot("2", "08:55", "09:45"),
        TimeSlot("3", "10:15", "11:05"),
        TimeSlot("4", "11:10", "12:00"),
        TimeSlot("5", "14:00", "14:50"),
        TimeSlot("6", "14:55", "15:45"),
        TimeSlot("7", "16:15", "17:05"),
        TimeSlot("8", "17:10", "18:00"),
        TimeSlot("9", "19:00", "19:50"),
        TimeSlot("10", "19:55", "20:45")
    )
    val density = LocalDensity.current.density
    val screenHeight = ((LocalConfiguration.current.screenHeightDp * density).toInt())/40

    Column(
        modifier = Modifier.padding(top = 40.dp)
    ) {
        for (slot in timeSlots) {
            Column(
                modifier = Modifier
                    .width(40.dp)
                    .height(screenHeight.dp)
                    .padding(start = 5.dp, end = 5.dp)
            ) {
                Text(
                    text = slot.slotNumber,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center),
                    fontSize = 12.sp
                )
                Text(text = slot.startTime, fontSize = 10.sp)
                Text(text = slot.endTime, fontSize = 10.sp)
            }
        }
    }
}

data class TimeSlot(val slotNumber: String, val startTime: String, val endTime: String)

@Composable
fun CourseWeekTime() {
    val dates = listOf(
        "8/28", "8/29", "8/30", "8/31", "9/1", "9/2", "9/3"
    )

    val daysOfWeek = listOf("周一", "周二", "周三", "周四", "周五", "周六", "周日")

    val density = LocalDensity.current.density
    val screenWidth = ((LocalConfiguration.current.screenWidthDp * density).toInt())/28

    Row() {
        for (i in 0 until 7) {
            Column(modifier = Modifier.width(screenWidth.dp).height(32.dp)) {
                Text(
                    text = daysOfWeek[i],
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                )
                Text(
                    text = dates[i],
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center),
                    fontSize = 10.sp
                )
            }
        }
    }
}

@Composable
fun TablePage() {
    val myList = listOf(
        mapOf(
            "1" to mapOf(
                "1" to mapOf(
                    "courseStart" to "1", "courseEnd" to "2",
                    "courseName" to "电路与数字系统",
                    "courseAddress" to "南湖校区博博3-B102",
                    "courseTeacher" to "张晓春",
                    "courseCredits" to "2.0",
                    "courseWeek" to "1-4"
                )
            )
        ),
    )

    val courseName = myList[0]["1"]?.get("1")?.get("courseName") ?: ""
    val courseAddress = myList[0]["1"]?.get("1")?.get("courseAddress") ?: ""
    val courseTeacher = myList[0]["1"]?.get("1")?.get("courseTeacher") ?: ""
    val courseCredits = myList[0]["1"]?.get("1")?.get("courseCredits") ?: ""
    val courseWeek = myList[0]["1"]?.get("1")?.get("courseWeek") ?: ""

    Column {
        Row {
            repeat(7) { // 重复6次，即6列
                Column {
                    repeat(2){
                        CourseTable(
                            courseName,
                            courseAddress,
                            courseTeacher,
                            courseCredits,
                            courseWeek
                        )
                    }
                    CourseTable(
                        "",
                        courseAddress,
                        courseTeacher,
                        courseCredits,
                        courseWeek
                    )
                    repeat(2){
                        CourseTable(
                            courseName,
                            courseAddress,
                            courseTeacher,
                            courseCredits,
                            courseWeek
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CourseTable(
    courseName: String,
    courseAddress: String,
    courseTeacher: String,
    courseCredits: String,
    courseWeek: String
) {
    val CourseName=courseName
    val showDialog = remember { mutableStateOf(false) }
    LocalContext.current
    var currentCourseName by remember { mutableStateOf(CourseName) }
    val density = LocalDensity.current.density
    val screenWidth = ((LocalConfiguration.current.screenWidthDp * density).toInt())/28
    val screenHeight = ((LocalConfiguration.current.screenHeightDp * density).toInt())/40


    Surface(
        modifier = Modifier
            .height(screenHeight * 2.dp)
            .width(screenWidth.dp)
            .clickable(
                onClick = { showDialog.value = true },
                indication = null, // 设置为 null 去掉水波纹效果
                interactionSource = remember { MutableInteractionSource() }
            )
            .padding(1.dp), // 添加一些内边距，以确保圆角不会被遮挡
        shape = RoundedCornerShape(4.dp), // 设置圆角
        color = Color(0xff5db990),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(), // 填充父级容器
            verticalArrangement = Arrangement.Center, // 垂直居中对齐
        ) {
            Text(
                text = CourseName,
                fontWeight = FontWeight(20),
                fontSize = 10.sp,
                modifier = Modifier.padding(
                    bottom = 4.dp,
                    start = 4.dp,
                    end = 4.dp,
                    top = 20.dp
                )
            )
            Text(
                text = courseAddress,
                fontSize = 7.sp,
                fontWeight = FontWeight(10),
                modifier = Modifier.padding(6.dp)
            )
            if (showDialog.value) {
                AlertDialog(
                    onDismissRequest = {
                        showDialog.value = false
                    },
                    title = {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = CourseName, fontSize = 25.sp)
                            IconButton(
                                onClick = {
                                    currentCourseName = ""
                                    showDialog.value = false // 关闭AlertDialog
                                }, modifier = Modifier.padding(start = 30.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Reset Course Name",
                                    //tint = Color(0xff5db990)
                                )
                            }
                        }
                    },
                    text = {
                        Column {
                            Row {
                                Text(text = "地点  ", fontSize = 16.sp)
                                Text(
                                    text = courseAddress,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(end = 4.dp, start = 8.dp), fontSize = 16.sp
                                )
                            }
                            Row {
                                Text(text = "老师  ", fontSize = 16.sp)
                                Text(
                                    text = courseTeacher,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(end = 4.dp, start = 8.dp), fontSize = 16.sp
                                )
                            }
                            Row {
                                Text(text = "学分  ", fontSize = 16.sp)
                                Text(
                                    text = courseCredits,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(end = 4.dp, start = 8.dp), fontSize = 16.sp
                                )
                            }
                            Row {
                                Text(text = "周次  ", fontSize = 16.sp)
                                Text(
                                    text = courseWeek,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(end = 4.dp, start = 8.dp), fontSize = 16.sp
                                )
                            }
                        }
                    },
                    confirmButton ={}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KxzAndroidTheme {
        CourseDayTime()
    }
}