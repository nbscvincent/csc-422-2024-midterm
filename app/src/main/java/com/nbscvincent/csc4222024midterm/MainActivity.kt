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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.nbscvincent.csc4222024midterm.screen.KtorApp
import com.nbscvincent.csc4222024midterm.screen.MainLogin
import com.nbscvincent.csc4222024midterm.screen.authscreen.LoginScreen
import com.nbscvincent.csc4222024midterm.ui.theme.CSC4222024MidtermTheme
import com.nbscvincent.csc4222024midterm.viewmodel.ScreenViewModel
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CSC4222024MidtermTheme {
                // A surface container using the 'background' color from the theme
                Timber.plant(Timber.DebugTree())

                val screenViewModel: ScreenViewModel by viewModels();

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    KtorApp(screenViewModel)
                }
            }
        }
    }
}