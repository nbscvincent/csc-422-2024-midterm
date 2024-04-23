package com.nbscvincent.csc4222024midterm

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.nbscvincent.csc4222024midterm.data.posts.viewmodel.PostViewModel
import com.nbscvincent.csc4222024midterm.data.qoutes.viewmodel.QuotesViewModel
import com.nbscvincent.csc4222024midterm.data.recipes.viewmodel.RecipeViewModel
import com.nbscvincent.csc4222024midterm.data.todos.viewmodel.TodosViewModel
import com.nbscvincent.csc4222024midterm.data.users.viewmodel.UsersViewModel
import com.nbscvincent.csc4222024midterm.routes.MainRoutes
import com.nbscvincent.csc4222024midterm.routes.Routes

@Composable
fun KtorAppContainer(
    postViewModel: PostViewModel = viewModel(factory = AppViewModelProvider.Factory),
    quotesViewModel: QuotesViewModel = viewModel(factory = AppViewModelProvider.Factory),
    usersViewModel: UsersViewModel = viewModel(factory = AppViewModelProvider.Factory),
    recipesViewModel: RecipeViewModel = viewModel(factory = AppViewModelProvider.Factory),
    todosViewModel: TodosViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {
    val navController: NavHostController = rememberNavController()

    Scaffold  (content = { padding->
        Box(modifier = Modifier.padding(padding)) {
            NavHost(navController = navController, startDestination = Routes.MAIN.name) {

                navigation(
                    startDestination = MainRoutes.HOME.name,
                    route = Routes.MAIN.name
                ) {
                    composable(route = MainRoutes.RECIPE.name) {
                        RecipeScreen(navController, recipesViewModel)
                    }

                    composable(route = MainRoutes.TODO.name) {
                        TodoScreen(navController, todosViewModel)
                    }

                    composable(route = MainRoutes.HOME.name) {
                        HomeScreen(navController, quotesViewModel)
                    }

                    composable(route = MainRoutes.PROFILE.name) {
                        ProfileScreen(navController)
                    }
                }



                navigation(
                    startDestination = PostRoutes.PostsScreen.name,
                    route = Routes.POSTS.name
                ) {
                    composable(route = PostRoutes.PostsScreen.name) {
                        PostsScreen(navController, postViewModel)
                    }
                }
            }
        }
    })
}
