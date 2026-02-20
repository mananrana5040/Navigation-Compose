package com.example.navigationcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.CustomAccessibilityAction
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.navigationcompose.R

@Composable
fun ProfileScreen() {

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_login),
            contentDescription = "This is the login screen",
            Modifier.size(200.dp)
        )

        Text(
            "Profile Screen",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = 10.dp)
        )
        Text("Hello, This is a Profile Screen")

        Row(
            Modifier.padding(top = 20.dp)
        ) {

            Button(
                onClick = {}, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ), modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Text("Login")
            }

            Button(
                onClick = {}, colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ), modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                Text(text = "Sign up")
            }
        }

        Text(
            text = "Please Sign up or Login to the account to proceed!",
            modifier = Modifier.padding(top = 10.dp),
            style = MaterialTheme.typography.labelSmall,
        )
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}