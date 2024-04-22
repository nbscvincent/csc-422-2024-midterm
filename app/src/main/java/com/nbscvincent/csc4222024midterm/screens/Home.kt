package com.nbscvincent.csc4222024midterm.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.nbscvincent.csc4222024midterm.NavHost.Route
import com.nbscvincent.csc4222024midterm.model.AppScreenViewModel
import com.nbscvincent.csc4222024midterm.model.ScreenViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Home (
    navController: NavHostController,
    screenViewModel: ScreenViewModel,
){
    val coroutineScope = rememberCoroutineScope()
    var greeting: String = ""
    //var qoutes: String = ""
    var qoutes by remember { mutableStateOf("") }

    val homeModel = viewModel<AppScreenViewModel>()
    greeting = homeModel.greeting()

    LaunchedEffect(key1 = true) {
        homeModel.getQoutes()
    }
    qoutes = homeModel.qoute.value

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .fillMaxWidth()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = greeting,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = qoutes,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    coroutineScope.launch {
                        navController.navigate(Route.Todos.name)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF783137)
                ),
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(
                    text = "Todos",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    coroutineScope.launch {
                        navController.navigate(Route.Recipes.name)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF783137)
                ),
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(
                    text = "Recipes",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White,
                )
            }
            Spacer(modifier = Modifier.height(300.dp))
            Button(
                onClick = {
                    coroutineScope.launch {
                        screenViewModel.unsetLogin()
                        navController.navigate(Route.Login.name)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF783137)
                ),
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(
                    text = "Sign Out",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White,
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}