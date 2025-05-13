package com.expense.expense_tracker.domain.usecase

import com.expense.expense_tracker.domain.model.Category
import com.expense.expense_tracker.data.remote.RetrofitClient

class ExpenseService {
    private val apiService = RetrofitClient.apiService

    suspend fun getCategories(): List<Category> {
        return apiService.getCategories("1");
    }
}
