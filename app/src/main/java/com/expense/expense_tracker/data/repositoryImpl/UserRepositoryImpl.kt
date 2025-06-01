package com.expense.expense_tracker.data.repositoryImpl

import com.expense.expense_tracker.data.remote.ApiService
import com.expense.expense_tracker.domain.model.Account
import com.expense.expense_tracker.domain.model.User
import com.expense.expense_tracker.domain.repository.AccountRepository
import com.expense.expense_tracker.domain.repository.UserRepository

class UserRepositoryImpl (private val apiService : ApiService) : UserRepository {
    override suspend fun loginUser(user: User): Boolean {
        return try {
            val response = apiService.loginUser(user.userName, user.password)
            response.userId.isNotEmpty()
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override suspend fun createUser(user: User) {
        TODO("Not yet implemented")
    }
}