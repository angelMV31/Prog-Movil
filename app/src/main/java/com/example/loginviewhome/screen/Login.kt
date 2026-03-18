package com.example.loginviewhome.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.loginviewhome.R
import com.example.loginviewhome.ui.theme.LoginViewHomeTheme

@Composable
fun LoginScreen(navController: NavHostController, modifier: Modifier = Modifier) {

    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val userValido = user.isNotEmpty()
    val passwordValido = password.isNotEmpty()

    val formularioValido = userValido && passwordValido

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF5E4AE3)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0xFFFFFFFF))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(30.dp))

            Image(
                painter = painterResource(id = R.drawable.login_view),
                contentDescription = null,
                modifier = Modifier
                    .height(220.dp)
            )

            Text("Login", fontSize = 30.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = user,
                onValueChange = {user = it},
                label = { Text("User") },
                isError = user.isEmpty(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                label = { Text("Password") },
                isError = password.isEmpty(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    navController.navigate("welcome")
                },
                enabled = formularioValido,

                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginViewHomeTheme {
        LoginScreen(rememberNavController())
    }
}