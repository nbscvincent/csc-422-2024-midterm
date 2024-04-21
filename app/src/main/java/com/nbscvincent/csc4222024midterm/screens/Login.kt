package com.nbscvincent.csc4222024midterm.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.nbscvincent.csc4222024midterm.model.AppScreenViewModel
import com.nbscvincent.csc4222024midterm.model.LoginReturn
import com.nbscvincent.csc4222024midterm.model.ScreenViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(
    navController: NavHostController,
    screenViewModel: ScreenViewModel,
) {
    val loginModel = viewModel<AppScreenViewModel>()
    val coroutineScope = rememberCoroutineScope()

    var username by remember { mutableStateOf("kminchelle") }
    var password by remember { mutableStateOf("0lelplR") }
    var passwordShow: Boolean by remember { mutableStateOf(false) }

    val openDialog = remember { mutableStateOf(false) }
    if (openDialog.value){
        DialogAlert(openDialog.value) { openDialog.value = false }
    }

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
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
                value = username,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { username = it },
                label = { Text(text = "Username") },
                textStyle = TextStyle(
                    color = Color.Black
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                ),
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
                },
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
                value = password,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                textStyle = TextStyle(
                    color = Color.Black
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                ),
                trailingIcon = {
                    val image = if (passwordShow)
                        Icons.Filled.Lock
                    else
                        Icons.Filled.Person

                    val description = if (passwordShow) "Hide Password" else "Show Password"

                    IconButton(onClick = {
                        passwordShow = !passwordShow
                    }) {
                        Icon(imageVector = image, contentDescription =  description)
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordShow) VisualTransformation.None else PasswordVisualTransformation(),
            )
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {
                    coroutineScope.launch {
                        val loginData = loginModel.checkLogin(username, password)
                        if (loginData[0].flag == 1){
                            openDialog.value = true
                        }else{
                            screenViewModel.setLogin()
                            navController.navigate(MainNav.HomePage.name)
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5742f5)
                ),
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(
                    text = "Sign In",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.White,
                )
            }

        }
    }
}