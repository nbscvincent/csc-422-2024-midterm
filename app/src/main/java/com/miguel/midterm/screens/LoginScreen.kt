package com.miguel.midterm.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miguel.midterm.R
import com.miguel.midterm.viewmodel.UsersViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

@Composable
fun LoginScreen(viewModel: UsersViewModel) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordShow: Boolean by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                .height(100.dp)
                .verticalScroll(scrollState)
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp, top = 0.dp, bottom = 0.dp)
                        .fillMaxSize()
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                val user = viewModel.LogInUser(username, password)
                                if (user != null) {
                                    Timber.tag("").i("LogIn User: %s", user)
                                } else {
                                    Timber.tag("").e("Invalid username or password")
                                }
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
                            text = "Log In",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.White,)
                    }


                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    ) {innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Fishbook",
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
            Text(
                text = "Welcome to Fishbook",
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(50.dp))

            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "sample icon",
                modifier = Modifier.size(150.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        Icon(imageVector = Icons.Filled.Person , contentDescription = "null", tint = Color.Red)
                    },
                    singleLine = true,
                    )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        val image = if (passwordShow)
                            Icons.Filled.Visibility
                        else
                            Icons.Outlined.VisibilityOff

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

                Spacer(modifier = Modifier.height(16.dp))
        }
    }




    }
}