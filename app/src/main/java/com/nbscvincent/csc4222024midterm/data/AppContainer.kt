package com.nbscvincent.csc4222024midterm.data

import android.content.Context
import com.nbscvincent.csc4222024midterm.data.offlineRepository.OfflineUserRepository
import com.nbscvincent.csc4222024midterm.data.onlineRepository.OnlineUserRepository
import com.nbscvincent.csc4222024midterm.data.repository.UserRepository
import com.nbscvincent.csc4222024midterm.database.KtorDatabase


interface AppContainer {
    val offlineUserRepository: OfflineUserRepository
    val onlineUserRepository: OnlineUserRepository





    class AppDataContainer(private val context: Context) : AppContainer {

        override val offlineUserRepository: OfflineUserRepository
            get() =   OfflineUserRepository(KtorDatabase.getDatabase(context).UserProfileDao())



        override val onlineUserRepository: OnlineUserRepository by lazy {
            OnlineUserRepository()
        }





    }
}