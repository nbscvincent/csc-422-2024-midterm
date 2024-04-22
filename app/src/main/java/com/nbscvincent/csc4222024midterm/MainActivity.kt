package com.nbscvincent.csc4222024midterm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.nbscvincent.csc4222024midterm.model.ScreenViewModel
import com.nbscvincent.csc4222024midterm.screens.MainPage
import com.nbscvincent.csc4222024midterm.ui.theme.CSC4222024MidtermTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val screenViewModel: ScreenViewModel by viewModels();

        setContent {
            CSC4222024MidtermTheme {
                MainPage(screenViewModel)
            }
        }
    }
}