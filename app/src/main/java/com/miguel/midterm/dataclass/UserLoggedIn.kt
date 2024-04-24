package com.miguel.midterm.dataclass

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber

object UserLoggedIn {
    private const val PREFS_NAME = "MyPrefs"
    private const val USER_KEY = "user"

    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()

    private val _UserLogIn = MutableStateFlow<UserLogIn?>(null)
    val loggedInUser = _UserLogIn.asStateFlow()

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val savedUserString = sharedPreferences.getString(USER_KEY, null)
        savedUserString?.let {
            _UserLogIn.value = gson.fromJson(it, UserLogIn::class.java)
        }
    }

    fun setLoggedInUser(user: UserLogIn) {
        if (_UserLogIn.value != user) {
            _UserLogIn.value = user
            saveUserToPrefs(user)
            Timber.tag("LoggedInUserHolder").i("Inserted LoggedInUser: %s", user)
        }
    }

    fun clearLoggedInUser() {
        _UserLogIn.value = null
        clearUserFromPrefs()
        Timber.tag("LoggedInUserHolder").i("Logged Out: %s", _UserLogIn.value)
    }

    fun getLoggedInUser(): UserLogIn? {
        return _UserLogIn.value
    }


    private fun saveUserToPrefs(user: UserLogIn) {
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
