package com.bonaagua.midterm.data.users.model

import android.provider.ContactsContract.CommonDataKinds.Phone

// Data class representing a logged-in user
data class LoggedInUser(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val username: String,
    var password: String,
    var email: String,
    var phone: String,
    var image: String,
)
