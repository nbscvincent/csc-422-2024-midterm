package com.bonaagua.midterm

import android.app.Application
import com.bonaagua.midterm.data.users.model.LoggedInUserHolder

class KtorApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        LoggedInUserHolder.init(this)
        container = AppDataContainer(this)
    }
}