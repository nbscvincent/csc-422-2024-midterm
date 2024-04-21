package com.bonaagua.midterm

import android.content.Context
import com.bonaagua.midterm.data.posts.repository.OnlinePostRepository
import com.bonaagua.midterm.data.quotes.repository.OnlineQuoteRepository
import com.bonaagua.midterm.data.recipes.repository.OnlineRecipeRepository
import com.bonaagua.midterm.data.todos.repository.OnlineTodoRepository
import com.bonaagua.midterm.data.users.repository.OfflineUserRepository
import com.bonaagua.midterm.data.users.repository.OnlineUserRepository


interface AppContainer {
    val onlinePostRepository: OnlinePostRepository
    val onlineQuoteRepository: OnlineQuoteRepository
    val onlineUserRepository: OnlineUserRepository
    val onlineRecipeRepository: OnlineRecipeRepository
    val onlineTodoRepository: OnlineTodoRepository
    val offlineUserRepository: OfflineUserRepository
}

class AppDataContainer (
    private val context: Context,
) : AppContainer {
    override val onlinePostRepository: OnlinePostRepository by lazy {
        OnlinePostRepository()
    }

    override val onlineQuoteRepository: OnlineQuoteRepository by lazy {
        OnlineQuoteRepository()
    }

    override val onlineUserRepository: OnlineUserRepository by lazy {
        OnlineUserRepository()
    }

    override val onlineRecipeRepository: OnlineRecipeRepository by lazy {
        OnlineRecipeRepository()
    }

    override val onlineTodoRepository: OnlineTodoRepository by lazy {
        OnlineTodoRepository()
    }

    override val offlineUserRepository: OfflineUserRepository by lazy {
        OfflineUserRepository(AppDatabase.getDatabase(context).userDao())
    }
}
