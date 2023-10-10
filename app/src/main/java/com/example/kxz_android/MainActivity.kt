package com.example.kxz_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.kxz_android.coursePage.PageWithIndicator
import com.example.kxz_android.person_page.electricity.ElectricityPage
import com.example.kxz_android.ui.theme.KxzAndroidTheme

class MainActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KxzAndroidTheme {
               PageWithIndicator()
            }
        }
    }
}

@Preview()
@Composable
fun preview(){
    KxzAndroidTheme {
        ElectricityPage()
    }
}
