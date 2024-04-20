package com.nbscvincent.csc4222024midterm.data

import android.content.Context

import com.nbscvincent.csc4222024midterm.data.onlineRepository.OnlineUserRepository


interface AppContainer {

    val onlineUserRepository: OnlineUserRepository




    class AppDataContainer(private val context: Context) : AppContainer {


        override val onlineUserRepository: OnlineUserRepository by lazy {
            OnlineUserRepository()
        }






    }
}