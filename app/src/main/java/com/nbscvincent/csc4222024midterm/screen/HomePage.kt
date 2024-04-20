package com.nbscvincent.csc4222024midterm.screen

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomAppBarDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRowDefaults.contentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.work.WorkManager
import coil.annotation.ExperimentalCoilApi
import kotlinx.coroutines.launch
import coil.compose.rememberImagePainter
import com.nbscvincent.csc4222024midterm.data.AppViewModelProvider
import com.nbscvincent.csc4222024midterm.navigation.routes.MainScreen
import com.nbscvincent.csc4222024midterm.preferences.PreferencesManager
import com.nbscvincent.csc4222024midterm.viewmodel.LoginScreenViewModel

import com.nbscvincent.csc4222024midterm.viewmodel.ScreenViewModel
import com.nbscvincent.csc4222024midterm.viewmodel.ToDoViewModel
import kotlinx.coroutines.coroutineScope
import timber.log.Timber
import java.util.Calendar

@SuppressLint("CoroutineCreationDuringComposition", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalCoilApi::class)
@Composable
fun HomePage(
    navController: NavController,
//    drawerState: DrawerState,
    screenViewModel: ScreenViewModel,

) {

    val viewModel: LoginScreenViewModel = viewModel(factory = AppViewModelProvider.Factory)

    val toDoViewModel = viewModel<ToDoViewModel>()


    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val username = preferencesManager.getData("username", "")
    val coroutineScope = rememberCoroutineScope()

    val application = LocalContext.current.applicationContext as Application
    val workManager = WorkManager.getInstance(application)



    var greeting by remember { mutableStateOf("") }
    var qoutes by remember { mutableStateOf("") }
    var todo by remember { mutableStateOf("") }


    LaunchedEffect(Unit) {
        greeting = greeting()
        qoutes = viewModel.getQuote()
        todo = viewModel.getTodo()

    }








    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Button(
                        onClick = {
                            navController.navigate(MainScreen.Profile.name)
                        }
                    ) {
                        Text("Profile")
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Gray),
                actions = {

                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Gray,
            ) {

                Button(onClick = {

                    screenViewModel.unsetLogin()
                    preferencesManager.saveData("login", "")
                    preferencesManager.saveData("username", "")
                    preferencesManager.saveData("firstName", "")
                    preferencesManager.saveData("lastName", "")
                    navController.navigate(MainScreen.Splash.name)

                }) {
                    Text("SignOut")
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
            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = greeting,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = qoutes,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                color = Color.Black,
            )
            Text(
                        text = todo,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )

            }


        }
    }

suspend fun greeting(): String {
    var msg = ""

    val calendarTime = Calendar.getInstance()

    val time = calendarTime.get(Calendar.HOUR_OF_DAY)
    when(time){
        in 6..11 -> msg = "Good Morning"
        in 12..17 -> msg = "Good Afternoon"
        in 18..22 -> msg = "Good Evening"
        else -> msg = "Good Morning"
    }
    return msg
}


