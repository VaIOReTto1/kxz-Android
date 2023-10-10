package com.example.kxz_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.kxz_android.Page.coursePage.NavigatorPage.BottomNavigationView
import com.example.kxz_android.Page.coursePage.PageWithIndicator
import com.example.kxz_android.Page.coursePage.electricity.ElectricityPage
import com.example.kxz_android.ui.theme.KxzAndroidTheme

class MainActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KxzAndroidTheme {
               BottomNavigationView()
            }
        }
    }
}

@Preview()
@Composable
fun preview(){
    KxzAndroidTheme {
        BottomNavigationView()
    }
}
