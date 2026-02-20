package com.example.navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationcompose.screens.HomeScreen
import com.example.navigationcompose.screens.ProfileScreen
import com.example.navigationcompose.screens.SearchScreen
import com.example.navigationcompose.ui.theme.NavigationComposeTheme
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object Search

@Serializable
object Profile

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Column(modifier = Modifier.fillMaxSize()) {
//        Spacer(Modifier.padding(top = 40.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
                .padding(8.dp)
                .clickable(onClickLabel = "Open Admin Dashboard") {  }
                .semantics(mergeDescendants = true) {
                    role = Role.Button
                },
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { navController.navigate(Home) }) { Text("Home") }
            Button(onClick = { navController.navigate(Search) }) { Text("Search") }
            Button(onClick = { navController.navigate(Profile) }) { Text("Profile") }

            IconButton(
                onClick = { /* Delete */ },
                modifier = Modifier.minimumInteractiveComponentSize() // Built-in: ensures 48dp x 48dp
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Admin Record"
                )
            }
        }

        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.weight(1f),
            enterTransition = { slideInHorizontally { it } },
            exitTransition = { slideOutHorizontally { -it } },
            popEnterTransition = { slideInHorizontally { -it } },
            popExitTransition = { slideOutHorizontally { it } }
        ) {
            composable<Home> { HomeScreen() }
            composable<Search> { SearchScreen() }
            composable<Profile> { ProfileScreen() }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}