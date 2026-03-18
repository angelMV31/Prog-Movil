package com.example.loginviewhome.screen

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.loginviewhome.ui.theme.LoginViewHomeTheme

@Composable
fun Register(navController: NavHostController, modifier: Modifier = Modifier) {

    var user by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }

    val nombreValido = user.matches(Regex("^[a-zA-Z ]+$"))
    val telefonoValido = telefono.matches(Regex("^\\d{10}$"))
    val correoValido = android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()
    val passwordsIguales = password == confirmPassword && password.isNotEmpty()

    val formularioValido = nombreValido && telefonoValido && correoValido && passwordsIguales

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

            Text("Register Screen", fontSize = 30.sp)

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = user,
                onValueChange = {user = it},
                label = { Text("User") },
                isError = user.isNotEmpty() && !nombreValido,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = correo,
                onValueChange = {correo = it},
                label = { Text("Correo") },
                isError = correo.isNotEmpty() && !correoValido,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = telefono,
                onValueChange = { telefono = it },
                label = { Text("Teléfono") },
                isError = telefono.isNotEmpty() && !telefonoValido,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {confirmPassword = it},
                label = { Text("ConfirmPassword") },
                isError = confirmPassword.isNotEmpty() && !passwordsIguales,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {
                    navController.navigate("welcome")
                },
                enabled = formularioValido,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Sign Up Using")
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    LoginViewHomeTheme {
        Register(rememberNavController())
    }
}