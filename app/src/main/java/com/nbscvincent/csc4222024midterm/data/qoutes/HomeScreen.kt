package com.nbscvincent.csc4222024midterm.data.qoutes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nbscvincent.csc4222024midterm.data.qoutes.viewmodel.QuotesViewModel
import com.nbscvincent.csc4222024midterm.data.users.model.LoggedInUserHolder
import com.nbscvincent.csc4222024midterm.routes.MainRoutes
import java.time.LocalDateTime

@Composable
fun HomeScreen(
    navController: NavController,
    quotesViewModel: QuotesViewModel
) {
    val randomQuote = quotesViewModel.randomQuote
    val currentTime = LocalDateTime.now()
    val greeting = when (currentTime.hour) {
        in 0..11 -> "Good morning"
        in 12..16 -> "Good afternoon"
        else -> "Good evening"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$greeting,",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column (
            modifier = Modifier.width(300.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            randomQuote?.let { quote ->
                Text(
                    text = "\"${quote.quote}\"",
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "- ${quote.author}",
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { navController.navigate(MainRoutes.TODO.name) }
            ) {
                Text(text = "Todos")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(onClick = { navController.navigate(MainRoutes.RECIPE.name) }
            ) {
                Text(text = "Recipes")
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { navController.navigate(MainRoutes.PROFILE.name) }
            ) {
                Text(text = "Profile")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(onClick = { LoggedInUserHolder.clearLoggedInUser() }
            ) {
                Text(text = "Logout")
            }
        }
    }

    LaunchedEffect(true) {
        quotesViewModel.getRandomQuote()
    }
}