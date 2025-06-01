package com.expense.expense_tracker.domain.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("user_name")
    val userName: String,

    @SerializedName("user_id")
    val userId: String,

    @SerializedName("password")
    val password: String,
)
