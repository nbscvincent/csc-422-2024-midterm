package com.miguel.midterm

import android.content.Context
import com.miguel.midterm.repository.onlinerepository.OnlinePostRepository
import com.miguel.midterm.repository.onlinerepository.OnlineQuoteRepository
import com.miguel.midterm.repository.onlinerepository.OnlineRecipeRepository
import com.miguel.midterm.repository.onlinerepository.OnlineTodoRepository
import com.miguel.midterm.repository.offlinerepository.OfflineUserRepository
import com.miguel.midterm.repository.onlinerepository.OnlineUserRepository


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
