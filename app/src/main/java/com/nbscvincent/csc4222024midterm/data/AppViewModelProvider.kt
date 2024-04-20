package com.nbscvincent.csc4222024midterm.data

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.nbscvincent.csc4222024midterm.viewmodel.LoginScreenViewModel
import com.nbscvincent.csc4222024midterm.viewmodel.ToDoViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {


        initializer {
            LoginScreenViewModel(
                ktorApplication().container.onlineUserRepository,
            )
        }

        initializer {
            ToDoViewModel(ktorApplication().container.onlineToDoRepository)
        }





    }
}
fun CreationExtras.ktorApplication(): KtorApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KtorApp)