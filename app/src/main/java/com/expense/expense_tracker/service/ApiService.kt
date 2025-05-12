package com.expense.expense_tracker.service
import com.expense.expense_tracker.domain.model.Category
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP


interface ApiService {
    @HTTP(method = "GET", path = "/api/account/category", hasBody = true)
    suspend fun getCategories(@Body userId: String): List<Category>
}