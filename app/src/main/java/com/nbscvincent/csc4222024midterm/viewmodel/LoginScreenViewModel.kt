package com.nbscvincent.csc4222024midterm.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbscvincent.csc4222024midterm.data.offlineRepository.OfflineUserRepository
import com.nbscvincent.csc4222024midterm.data.onlineRepository.OnlineUserRepository
import com.nbscvincent.csc4222024midterm.data.repository.UserRepository
import com.nbscvincent.csc4222024midterm.model.Credentials
import com.nbscvincent.csc4222024midterm.model.UserProfile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import timber.log.Timber

class LoginScreenViewModel(
    private val onlineUserRepository: OnlineUserRepository,
    private val user: Credentials
) : ViewModel() {

}

