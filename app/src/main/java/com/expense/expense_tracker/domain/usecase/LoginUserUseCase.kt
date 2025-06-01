package com.expense.expense_tracker.domain.usecase

import com.expense.expense_tracker.domain.model.User
import com.expense.expense_tracker.domain.repository.UserRepository

class LoginUserUseCase(private val repo: UserRepository) {
    suspend operator fun invoke(user: User): Boolean = repo.loginUser(user)
}
