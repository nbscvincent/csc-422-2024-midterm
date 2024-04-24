package com.miguel.midterm.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.miguel.midterm.dataclass.UserLoggedIn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    val loggedInUser = UserLoggedIn.loggedInUser.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Profile",
                            fontWeight = FontWeight.Bold,
                            fontSize = 45.sp, // Set text color to black
                            modifier = Modifier,
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }
                    ) {
                        Icon(
                            Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back",
                            tint = Color.Red // Set icon tint color to black
                        )
                    }
                },

                )

        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileTextField("First Name", loggedInUser.value?.firstName ?: "")
            ProfileTextField("Last Name", loggedInUser.value?.lastName ?: "")
            ProfileTextField("Maiden Name", loggedInUser.value?.maidenName ?: "")
            ProfileTextField("Username", loggedInUser.value?.username ?: "")
            ProfileTextField("Email", loggedInUser.value?.email ?: "")
            ProfileTextField("Phone", loggedInUser.value?.phone ?: "")
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTextField(label: String, value: String) {
    OutlinedTextField(
        value = value,
        onValueChange = { /* Nothing */ },
        enabled = true,
        modifier = Modifier
            .width(300.dp),
        readOnly = true,
        label = { Text(text = label, fontWeight = FontWeight.Bold ) }, // Display label as placeholder
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Transparent, // Set border color to transparent
            focusedBorderColor = Color.Transparent, // Set border color to transparent
            disabledBorderColor = Color.Transparent // Set border color to transparent
        )
    )
}