package com.miguel.midterm

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.miguel.midterm.viewmodel.PostViewModel
import com.miguel.midterm.viewmodel.QuotesViewModel
import com.miguel.midterm.viewmodel.RecipeViewModel
import com.miguel.midterm.viewmodel.TodosViewModel
import com.miguel.midterm.viewmodel.UsersViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            PostViewModel(ktorApplication().container.onlinePostRepository)
        }

        initializer {
            QuotesViewModel(ktorApplication().container.onlineQuoteRepository)
        }

        initializer {
            UsersViewModel(
                ktorApplication().container.onlineUserRepository,
                ktorApplication().container.offlineUserRepository
            )
        }

        initializer {
            RecipeViewModel(ktorApplication().container.onlineRecipeRepository)
        }

        initializer {
            TodosViewModel(ktorApplication().container.onlineTodoRepository)
        }
    }
}

fun CreationExtras.ktorApplication(): KtorApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KtorApplication)