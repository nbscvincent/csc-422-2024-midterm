package com.nbscvincent.csc4222024midterm.data.users.model

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object LoggedInUserHolder {
    private const val PREFS_NAME = "MyPrefs"
    private const val USER_KEY = "user"

    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()

    private val _loggedInUser = MutableStateFlow<LoggedInUser?>(null)
    val loggedInUser = _loggedInUser.asStateFlow()

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val savedUserString = sharedPreferences.getString(USER_KEY, null)
        savedUserString?.let {
            _loggedInUser.value = gson.fromJson(it, LoggedInUser::class.java)
        }
    }

    fun setLoggedInUser(user: LoggedInUser) {
        if (_loggedInUser.value != user) {
            _loggedInUser.value = user
            saveUserToPrefs(user)

            // Log the inserted LoggedInUser
            Log.i("LoggedInUserHolder", "Inserted LoggedInUser: $user")
        }
    }

    fun clearLoggedInUser() {
        _loggedInUser.value = null
        clearUserFromPrefs()
        Log.i("LoggedInUserHolder", "Logged Out: ${_loggedInUser.value}")
    }

    fun getLoggedInUser(): LoggedInUser? {
        return _loggedInUser.value
    }

    fun isLoggedIn(): Boolean {
        return _loggedInUser.value != null
    }

    private fun saveUserToPrefs(user: LoggedInUser) {
        val editor = sharedPreferences.edit()
        val userString = gson.toJson(user)
        editor.putString(USER_KEY, userString)
        editor.apply()
    }

    private fun clearUserFromPrefs() {
        val editor = sharedPreferences.edit()
        editor.remove(USER_KEY)
        editor.apply()
    }
}
