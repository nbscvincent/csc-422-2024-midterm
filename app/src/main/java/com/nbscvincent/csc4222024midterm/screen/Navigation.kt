package com.nbscvincent.csc4222024midterm.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nbscvincent.csc4222024midterm.navigation.routes.MainScreen
import com.nbscvincent.csc4222024midterm.preferences.PreferencesManager
import com.nbscvincent.csc4222024midterm.screen.authscreen.LoginScreen
import com.nbscvincent.csc4222024midterm.viewmodel.ScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KtorApp (
    screenViewModel: ScreenViewModel
){
    val navController: NavHostController = rememberNavController()

    Scaffold {
        NavHost(
            navController = navController,
            startDestination = MainScreen.Splash.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = MainScreen.Splash.name) {
                SplashScreen( navController, screenViewModel )
            }
            composable(route = MainScreen.CheckLogin.name) {
                CheckLogin( screenViewModel )
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckLogin( screenViewModel: ScreenViewModel ){
    val navController: NavHostController = rememberNavController()

    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val data = preferencesManager.getData("login", "")

    if (data == ""){
        MainLogin(screenViewModel)
    }else{
        MainHomeScreen(navController, screenViewModel)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLogin(

    screenViewModel: ScreenViewModel
){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController: NavHostController = rememberNavController()

    Scaffold {
        Column(modifier = Modifier.padding(it)) {
        }
        NavHost(
            navController = navController,
            startDestination = MainScreen.Login.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = MainScreen.Login.name) {
                LoginScreen( navController, screenViewModel )
            }
           /* composable(route = MainScreen.RegistrationScreen.name) {
                RegistrationScreen( navController )
            }*/
            composable(route = MainScreen.HomePage.name) {
                HomePage( navController, screenViewModel )
            }
            composable(route = MainScreen.CheckLogin.name) {
                CheckLogin( screenViewModel )
            }
            composable(route = MainScreen.Splash.name) {
                SplashScreen( navController, screenViewModel )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainHomeScreen(
    navController: NavHostController,
    screenViewModel: ScreenViewModel
){


    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }

    Scaffold(
        bottomBar = {

        }
    ) {
        Column(modifier = Modifier.padding(it)) {
        }
        NavHost(
            navController = navController,
            startDestination = MainScreen.HomePage.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = MainScreen.Login.name) {
                LoginScreen(navController, screenViewModel)
            }
//            composable(route = MainScreen.RegistrationScreen.name) {
//                RegistrationScreen(navController)
//            }
            composable(route = MainScreen.HomePage.name) {
                HomePage(navController, screenViewModel)
            }
            composable(route = MainScreen.CheckLogin.name) {
                CheckLogin(screenViewModel)
            }
            composable(route = MainScreen.Splash.name) {
                SplashScreen(navController, screenViewModel)
            }
//            composable(route = MainScreen.Profile.name) {
//                Profile(navController, screenViewModel)
//            }

        }
    }
}