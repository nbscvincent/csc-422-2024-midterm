package com.nbscvincent.csc4222024midterm.data

import android.content.Context
import com.nbscvincent.csc4222024midterm.data.offlineRepository.OfflinePostRepository

import com.nbscvincent.csc4222024midterm.data.onlineRepository.OnlineToDoRepository

import com.nbscvincent.csc4222024midterm.data.onlineRepository.OnlineUserRepository
import com.nbscvincent.csc4222024midterm.data.repository.ToDoRepository
import com.nbscvincent.csc4222024midterm.database.KtorDatabase


interface AppContainer {

    val onlineUserRepository: OnlineUserRepository
    val onlineToDoRepository: OnlineToDoRepository


    class AppDataContainer(private val context: Context) : AppContainer {


        override val onlineUserRepository: OnlineUserRepository by lazy {
            OnlineUserRepository()
        }

        override val onlineToDoRepository: OnlineToDoRepository by lazy {
            OnlineToDoRepository()
        }



    }
}