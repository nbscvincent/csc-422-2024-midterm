package com.nbscvincent.csc4222024midterm.data

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.viewModelFactory


object AppViewModelProvider {
    val Factory = viewModelFactory {


    }
}
fun CreationExtras.ktorApplication(): KtorApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KtorApp)