package com.nbscvincent.csc4222024midterm

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.nbscvincent.csc4222024midterm.data.posts.viewmodel.PostViewModel
import com.nbscvincent.csc4222024midterm.data.qoutes.viewmodel.QuotesViewModel
import com.nbscvincent.csc4222024midterm.data.recipes.viewmodel.RecipeViewModel
import com.nbscvincent.csc4222024midterm.data.todos.viewmodel.TodosViewModel
import com.nbscvincent.csc4222024midterm.data.users.viewmodel.UsersViewModel

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