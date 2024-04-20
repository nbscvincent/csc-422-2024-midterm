package com.nbscvincent.csc4222024midterm.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbscvincent.csc4222024midterm.data.offlineRepository.OfflineUserRepository
import com.nbscvincent.csc4222024midterm.data.onlineRepository.OnlineUserRepository
import com.nbscvincent.csc4222024midterm.model.Credentials
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber


class LoginScreenViewModel(private val onlineUserRepository: OnlineUserRepository, private val offlineUserRepository: OfflineUserRepository) : ViewModel() {

    /**
     * Holds current user ui state
     */
    var userUiState by mutableStateOf(UserUiState())
        private set
    /**
     * Select a [User] in the Room database
     */
    suspend fun selectUser(userDetails: UserDetails = userUiState.userDetails): Flow<UserProfile?>? {
        var flow : Flow<UserProfile?>? = null

        if (validateInput()) {
            //flow = usersRepository.getUserPasswordStream(userDetails.username, userDetails.password)
            try {
                flow = onlineUserRepository.getUserPasswordStream(userDetails.username, userDetails.password);
                offlineUserRepository.getUserPasswordStream(userDetails.username, userDetails.password)
            } catch (e: Exception){
                Timber.i("SAMPLE $e")
            }
        }
        return flow
    }
    private fun validateInput(uiState: UserDetails = userUiState.userDetails): Boolean {
        return with(uiState) {
            username.isNotBlank() && password.isNotBlank()
        }
    }
}
/**
 * Represents Ui State for an User.
 */
data class UserUiState(
    var userDetails: UserDetails = UserDetails(),
    val isEntryValid: Boolean = false,
)
data class UserDetails(
    val username: String = "",
    val password: String = "",
    val firstName: String = "",

    val lastName: String = ""
)
/**
 * Extension function to convert [UserUiState] to [User]. If the value of [UserDetails.price] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [UserUiState] is not a valid [Int], then the quantity will be set to 0
 */
fun UserDetails.toUser(): UserProfile = UserProfile(
    username = username,
    password = password,
    firstName = firstName,
    lastName = lastName
)
/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun UserProfile.toUserUiState(isEntryValid: Boolean = false): UserUiState = UserUiState(
    userDetails = this.toUserDetails(),
    isEntryValid = isEntryValid
)
/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun UserProfile.toUserDetails(): UserDetails = UserDetails(
    username = username,
    password  = password,
    firstName = firstName,
    lastName = lastName
)
