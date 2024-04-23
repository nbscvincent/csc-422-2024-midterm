package com.nbscvincent.csc4222024midterm

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.nbscvincent.csc4222024midterm.data.users.LoginScreen
import com.nbscvincent.csc4222024midterm.data.users.viewmodel.UsersViewModel
import com.nbscvincent.csc4222024midterm.routes.AuthRoutes
import com.nbscvincent.csc4222024midterm.routes.Routes

@Composable
fun AuthContainer (
    usersViewModel: UsersViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val navController: NavHostController = rememberNavController()
    Scaffold  (content = { padding ->
        Box(modifier = Modifier.padding(padding)) {
            NavHost(navController = navController, startDestination = Routes.AUTH.name) {
                navigation(
                    startDestination = AuthRoutes.LOGIN.name,
                    route = Routes.AUTH.name
                ) {
                    composable(route = AuthRoutes.LOGIN.name) {
                        LoginScreen(usersViewModel)
                    }
                }
            }
        }
    })
}