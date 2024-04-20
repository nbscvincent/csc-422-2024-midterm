package com.nbscvincent.csc4222024midterm.data

import android.app.Application

class KtorApp : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer.AppDataContainer(this)
    }
}