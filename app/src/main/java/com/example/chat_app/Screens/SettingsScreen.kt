package com.example.chat_app.Screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chat_app.Database.Main

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    val context = LocalContext.current
    Scaffold(containerColor = Color(14, 22, 33), topBar = {
        TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(
                23, 33, 43
            )
        ), title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { navController.navigate("Home") }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Icon",
                        tint = Color.White,
                    )
                }
                Text(Main.getSavedUser(context), color = Color.White)
            }
        })
    }) { innerPadding ->
        var password by remember { mutableStateOf(TextFieldValue("")) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .padding(innerPadding),
        ) {
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "Reset Password",
                color = Color.White
            )
            OutlinedTextField(
                colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                value = password,
                onValueChange = {
                    password = it
                },
                label = { Text(text = "Your New Password", color = Color.White) },
                placeholder = { Text(text = "Password", color = Color.White) },
            )
            Button(modifier = Modifier.padding(top = 10.dp), onClick = {
                Main.setPassword(Main.getSavedUser(context), password.text)
                Toast.makeText(context, "Password changed successfully", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Reset")
            }
            Button(modifier = Modifier.padding(top = 5.dp),
                colors = ButtonDefaults.buttonColors(Color.Red),
                onClick = {
                    Main.saveUser(context, "")
                    navController.navigate("SignIn")
                }) {
                Text(text = "Log Out")
            }
        }
    }
}