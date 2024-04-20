package com.nbscvincent.csc4222024midterm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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