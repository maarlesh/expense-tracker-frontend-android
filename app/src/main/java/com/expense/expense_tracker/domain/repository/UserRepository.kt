package com.expense.expense_tracker.domain.repository

import com.expense.expense_tracker.domain.model.Account
import com.expense.expense_tracker.domain.model.User

interface UserRepository {
    suspend fun loginUser(user : User) : Boolean;
    suspend fun createUser(user : User);
}