package com.nbscvincent.csc4222024midterm.data

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.nbscvincent.csc4222024midterm.viewmodel.LoginScreenViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {


        initializer {
            LoginScreenViewModel(
                ktorApplication().container.onlineUserRepository,
            )
        }


    }
}
fun CreationExtras.ktorApplication(): KtorApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KtorApp)