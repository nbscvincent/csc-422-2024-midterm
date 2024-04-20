package com.nbscvincent.csc4222024midterm.screen.authscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

import com.nbscvincent.csc4222024midterm.R
import com.nbscvincent.csc4222024midterm.data.AppViewModelProvider

import com.nbscvincent.csc4222024midterm.model.UserProfile
import com.nbscvincent.csc4222024midterm.navigation.routes.MainScreen
import com.nbscvincent.csc4222024midterm.preferences.PreferencesManager
import com.nbscvincent.csc4222024midterm.screen.loginAlert
import com.nbscvincent.csc4222024midterm.viewmodel.LoginScreenViewModel

import com.nbscvincent.csc4222024midterm.viewmodel.ScreenViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController,
    screenViewModel: ScreenViewModel,

) {
    val viewModel: LoginScreenViewModel = viewModel(factory = AppViewModelProvider.Factory)

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isChecked = remember { mutableStateOf(false) }
    var passwordShow: Boolean by remember { mutableStateOf(false) }
    val openDialog = remember { mutableStateOf(false) }
    if (openDialog.value){
        loginAlert(openDialog.value) { openDialog.value = false }
    }
    val coroutineScope = rememberCoroutineScope()
    var isTextFieldFocused by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }

    val scrollState = rememberScrollState()


    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(295.dp).verticalScroll(scrollState),
                containerColor = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp, top = 0.dp, bottom = 0.dp)
                        .fillMaxSize()
                        .fillMaxWidth()
                        .background(Color.White),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                viewModel.checkLogin(username, password)
                            }
                        },
                        modifier = Modifier
                            .absolutePadding(
                                left = 5.dp,
                                right = 5.dp,

                                )
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        shape = RoundedCornerShape(8.dp),
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
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .fillMaxWidth()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Fitness Logo",
                modifier = Modifier.size(250.dp)
            )
            Text(
                text = "Welcome back!",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Black
            )
            Text(
                text = "Sign in to access your account",
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(50.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
                value = username,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { username = it },
                label = { Text(text = "Username", color = Color.Black) },
                colors = TextFieldDefaults.outlinedTextFieldColors(

                ),
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "Email" , tint = Color.Red)
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
                label = { Text(text = "Password", color = Color.Black) },

                colors = TextFieldDefaults.outlinedTextFieldColors(


                    unfocusedBorderColor = Color.Gray, // Change to desired color when not focused


                ),
                trailingIcon = {
                    val image = if (passwordShow)
                        Icons.Filled.Visibility
                    else
                        Icons.Filled.VisibilityOff

                    val description = if (passwordShow) "Hide Password" else "Show Password"

                    IconButton(onClick = {
                        passwordShow = !passwordShow
                    }) {
                        Icon(imageVector = image, contentDescription =  description, tint = Color.Red)
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordShow) VisualTransformation.None else PasswordVisualTransformation(),

                )

        }
    }
}