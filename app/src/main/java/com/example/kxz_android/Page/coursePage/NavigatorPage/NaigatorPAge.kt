package com.example.kxz_android.Page.coursePage.NavigatorPage

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kxz_android.Page.coursePage.PageWithIndicator
import com.example.kxz_android.Page.coursePage.electricity.ElectricityPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationView() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavItem("课表", Icons.Default.Home,"coursepage"),
        BottomNavItem("主页", Icons.Default.Person,"mypage")
    )
    var selected by remember { mutableStateOf(0) } // 用于跟踪选中的底部项

    Scaffold(
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp).fillMaxWidth(),
                backgroundColor = Color(0xff0abea5)
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                items.forEachIndexed { index, item ->
                    val isSelected = currentRoute == item.route

                    BottomNavigationItem(
                        selected = isSelected,
                        onClick = {
                            navController.navigate(item.route) {
                                launchSingleTop = true
                            }
                            selected = index // 更新选中状态
                        },
                        icon = {
                               Icon(
                                   item.icon,
                                   contentDescription = null,
                                   modifier = Modifier.size(50.dp),
                                   tint = Color.White
                               )
                        },
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "coursepage",
            modifier = Modifier
                .padding(innerPadding)
        ) {
            composable("coursepage") {
                PageWithIndicator()
            }
            composable("mypage") {
                ElectricityPage()
            }
        }
    }
}

data class BottomNavItem(val label: String, val icon: ImageVector, val route: String)

@Preview
@Composable
fun navi(){
    BottomNavigationView()
}

