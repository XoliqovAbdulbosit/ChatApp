package com.example.chat_app.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chat_app.Database.Main
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        delay(1250)
        if (Main.getSavedUser(context) == "") navController.navigate("SignIn")
        else navController.navigate("Home")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(14, 22, 33)),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = Modifier.size(200.dp),
            imageVector = Icons.Default.MailOutline,
            contentDescription = "App Icon",
            tint = Color(108, 120, 131),
        )
    }
}