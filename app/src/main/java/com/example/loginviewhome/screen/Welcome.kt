package com.example.loginviewhome.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
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
fun Greeting(navController: NavHostController, modifier: Modifier = Modifier) {
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
                painter = painterResource(id = R.drawable.login),
                contentDescription = null,
                modifier = Modifier
                    .height(220.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            androidx.compose.material3.Text(
                text = "Hello",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000)
            )

            Spacer(modifier = Modifier.height(8.dp))

            androidx.compose.material3.Text(
                text = "Welcome To Little Drop, where you manage you daily tasks",
                fontSize = 14.sp,
                color = Color(0xFF808080)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .clickable{
                        navController.navigate("login")
                    }
                    .background(Color(0xFF5E4AE3)),
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.material3.Text(
                    text = "Login",
                    color = (Color(0xFFFFFFFF)),
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFFFFFFFF))
                    .clickable{
                        navController.navigate("register")
                    }
                    .border(
                        width = 2.dp,
                        color = Color(0xFF5E4AE3),
                        shape = RoundedCornerShape(30.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.material3.Text(
                    text = "Sign Up",
                    color = Color(0xFF5E4AE3),
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            androidx.compose.material3.Text(
                text = "Sign up using",
                fontSize = 12.sp,
                color = Color(0xFF808080)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF3b5998)),
                    contentAlignment = Alignment.Center
                ) {
                    androidx.compose.material3.Text(text = "f", color = Color(0xFFFFFFFF))
                }

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFFDB4437)),
                    contentAlignment = Alignment.Center
                ) {
                    androidx.compose.material3.Text(text = "G+", color = Color(0xFFFFFFFF))
                }

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF0A66C2)),
                    contentAlignment = Alignment.Center
                ) {
                    androidx.compose.material3.Text(text = "in", color = Color(0xFFFFFFFF))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginViewHomeTheme {
        Greeting(rememberNavController())
    }
}