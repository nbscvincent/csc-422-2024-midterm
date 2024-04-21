package com.bonaagua.midterm

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.bonaagua.midterm.data.posts.viewmodel.PostViewModel
import com.bonaagua.midterm.data.quotes.viewmodel.QuotesViewModel
import com.bonaagua.midterm.data.recipes.viewmodel.RecipeViewModel
import com.bonaagua.midterm.data.todos.viewmodel.TodosViewModel
import com.bonaagua.midterm.data.users.viewmodel.UsersViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            PostViewModel(ktorapp().container.onlinePostRepository)
        }

        initializer {
            QuotesViewModel(ktorapp().container.onlineQuoteRepository)
        }

        initializer {
            UsersViewModel(
                ktorapp().container.onlineUserRepository,
                ktorapp().container.offlineUserRepository
            )
        }

        initializer {
            RecipeViewModel(ktorapp().container.onlineRecipeRepository)
        }

        initializer {
            TodosViewModel(ktorapp().container.onlineTodoRepository)
        }
    }
}

fun CreationExtras.ktorapp(): KtorApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KtorApplication)