package com.example.kxz_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.kxz_android.ui.component.Toast.TosatPrevie1
import com.example.kxz_android.ui.theme.KxzAndroidTheme

class MainActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KxzAndroidTheme {
                TosatPrevie1()
            }
        }
    }
}
