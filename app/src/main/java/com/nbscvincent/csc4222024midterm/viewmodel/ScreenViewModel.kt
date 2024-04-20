package com.nbscvincent.csc4222024midterm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbscvincent.csc4222024midterm.navigation.state.ScreenUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ScreenViewModel : ViewModel() {
    private val _loading = MutableStateFlow(true)
    val loading = _loading.asStateFlow()
    private val _uiState = MutableStateFlow(ScreenUiState())

    private val _isLogin = MutableStateFlow(false)
    val isLogin = _isLogin.asStateFlow()
    fun runSplashScreen() {
        viewModelScope.launch {
            // run background task here
            delay(2000)
            _loading.value = false
        }
    }
    fun checkLogin(): Boolean {
        return _isLogin.value
    }
    fun setLogin(){
        _isLogin.value = true;
    }
    fun unsetLogin(){
        _isLogin.value = false;
    }
}