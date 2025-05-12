package com.expense.expense_tracker.service

import com.expense.expense_tracker.domain.model.Category

class ExpenseService {
    private val apiService = RetrofitClient.apiService

    suspend fun getCategories(): List<Category> {
        return apiService.getCategories("1");
    }
}
