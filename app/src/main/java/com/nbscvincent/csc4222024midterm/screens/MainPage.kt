package com.nbscvincent.csc4222024midterm.screens

import android.annotation.SuppressLint
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nbscvincent.csc4222024midterm.NavHost.Route
import com.nbscvincent.csc4222024midterm.model.ScreenViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainPage(
    screenViewModel: ScreenViewModel
){
    CheckLogin(screenViewModel)

}


@Composable
fun CheckLogin( screenViewModel: ScreenViewModel ){
    val navController: NavHostController = rememberNavController()
    if (screenViewModel.checkLogin()){
        MainLogin(navController, screenViewModel)
    }else{
        MainHomeScreen(navController, screenViewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLogin(
    navController: NavHostController,
    screenViewModel: ScreenViewModel
){
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
        }
        NavHost(
            navController = navController,
            startDestination = Route.Login.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = Route.Login.name) {
                Login( navController, screenViewModel )
            }
            composable(route = Route.HomePage.name) {
                Home(navController, screenViewModel)
            }
        }
    }
}


@Composable
fun MainHomeScreen(
    navController: NavHostController,
    screenViewModel: ScreenViewModel
){
    Scaffold{
        Column(modifier = Modifier.padding(it)) {
        }
        NavHost(
            navController = navController,
            startDestination = Route.HomePage.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = Route.Login.name) {
                Login( navController, screenViewModel )
            }
            composable(route = Route.HomePage.name) {
                Home(navController, screenViewModel)
            }
            composable(route = Route.Recipes.name) {
                Recipes(navController, screenViewModel)
            }
            composable(route = Route.Todos.name) {
                Todos(navController, screenViewModel)
            }
        }
    }
}
