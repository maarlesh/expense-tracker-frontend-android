package com.expense.expense_tracker.data.remote
import com.expense.expense_tracker.domain.model.Account
import com.expense.expense_tracker.domain.model.Category
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService {
    @HTTP(method = "GET", path = "/api/account/category", hasBody = true)
    suspend fun getCategories(@Body userId: String): List<Category>

    @GET("/api/account")
    suspend fun getAccounts(@Query("userId") userId: String): List<Account>
}