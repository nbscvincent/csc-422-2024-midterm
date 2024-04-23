package com.nbscvincent.csc4222024midterm

import android.app.Application
import com.nbscvincent.csc4222024midterm.data.users.model.LoggedInUserHolder

class KtorApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        LoggedInUserHolder.init(this)
        container = AppDataContainer(this)