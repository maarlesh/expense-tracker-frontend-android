package com.expense.expense_tracker.presentation.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.expense.expense_tracker.domain.model.Account
import com.expense.expense_tracker.domain.model.User
import com.expense.expense_tracker.domain.usecase.LoginUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUserUseCase: LoginUserUseCase) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn

    fun login(username: String, password: String) {

        val user = User(username, "1", username)
        _user.value = user

        viewModelScope.launch {
            val result = loginUserUseCase(user)
            Log.d("Login", "Login result: $result")
            _isLoggedIn.value = result
        }
    }
}
