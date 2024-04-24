package com.miguel.midterm

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.miguel.midterm.screens.PostsScreen
import com.miguel.midterm.screens.HomeScreen
import com.miguel.midterm.screens.RecipeScreen
import com.miguel.midterm.screens.TodoScreen
import com.miguel.midterm.screens.ProfileScreen
import com.miguel.midterm.routes.MainRoutes
import com.miguel.midterm.routes.Routes

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    Scaffold  (content = { padding->
        Box(modifier = Modifier.padding(padding)) {
            NavHost(navController = navController, startDestination = Routes.MAIN.name) {

                navigation(
                    startDestination = MainRoutes.HOME.name,
                    route = Routes.MAIN.name
                ) {
                    composable(route = MainRoutes.RECIPE.name) {
                        RecipeScreen(navController)
                    }

                    composable(route = MainRoutes.TODO.name) {
                        TodoScreen(navController)
                    }

                    composable(route = MainRoutes.HOME.name) {
                        HomeScreen(navController)
                    }

                    composable(route = MainRoutes.PROFILE.name) {
                        ProfileScreen(navController)
                    }

                    composable(route = MainRoutes.POST.name) {
                        PostsScreen(navController)
                    }
                }


            }
        }
    })
}
