package com.miguel.midterm.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.miguel.midterm.AppViewModelProvider
import com.miguel.midterm.viewmodel.QuotesViewModel
import com.miguel.midterm.dataclass.UserLoggedIn
import com.miguel.midterm.dataclass.UserLoggedIn.loggedInUser
import com.miguel.midterm.routes.MainRoutes
import java.time.LocalDateTime

@Composable
fun HomeScreen(
    navController: NavController,
    quotesViewModel: QuotesViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {
    val scrollState = rememberScrollState()
    val randomQuote = quotesViewModel.randomQuote
    val currentTime = LocalDateTime.now()
    val greeting = when (currentTime.hour) {
        in 0..11 -> "Good morning"
        in 12..16 -> "Good afternoon"
        else -> "Good evening"
    }
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(100.dp)
                .verticalScroll(scrollState),

            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 25.dp, end = 25.dp, top = 0.dp, bottom = 0.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Button(
                        onClick = {
                            UserLoggedIn.clearLoggedInUser()
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
                            text = "Logout",
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
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$greeting,",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(16.dp))


            randomQuote?.let { quote ->
                Text(
                    text = "\"${quote.quote}\"",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "- ${quote.author}",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold

                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                Spacer(modifier = Modifier.height(50.dp))

                val imagePainter = rememberImagePainter(loggedInUser.value?.image ?: "")
                Image(
                    painter = imagePainter,
                    contentDescription = "User Image",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(shape = RectangleShape)
                )


                Spacer(modifier = Modifier.height(25.dp))

                Button(
                    onClick = { navController.navigate(MainRoutes.PROFILE.name) },
                    modifier = Modifier
                        .absolutePadding(
                            left = 5.dp,
                            right = 5.dp,
                        ),
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    shape = RoundedCornerShape(20.dp),
                ) {
                    Text(
                        text = "Profile",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White,
                    )
                }


                Button(
                    onClick = {
                        navController.navigate(MainRoutes.TODO.name)
                    },
                    modifier = Modifier
                        .absolutePadding(
                            left = 5.dp,
                            right = 5.dp,
                        ),
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    shape = RoundedCornerShape(20.dp),
                ) {
                    Text(
                        text = "ToDo",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White,
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Button(
                    onClick = { navController.navigate(MainRoutes.RECIPE.name) },
                    modifier = Modifier
                        .absolutePadding(
                            left = 5.dp,
                            right = 5.dp,
                        ),
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    shape = RoundedCornerShape(20.dp),
                ) {
                    Text(
                        text = "Recipes",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White,
                    )
                }
//
//                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        navController.navigate(MainRoutes.POST.name)
                              },
                    modifier = Modifier
                        .absolutePadding(
                            left = 5.dp,
                            right = 5.dp,
                        ),
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    shape = RoundedCornerShape(20.dp),
                ) {
                    Text(
                        text = "Posts",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White,
                    )
                }


                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }

    LaunchedEffect(true) {
        quotesViewModel.getRandomQuote()
    }
}