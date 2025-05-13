package com.expense.expense_tracker.domain.model

import com.google.gson.annotations.SerializedName

data class Account(
    @SerializedName("account_id")
    val accountId: String,

    @SerializedName("account_name")
    val accountName: String,

    val balance: Double,

    @SerializedName("user_id")
    val userId: String,

    @SerializedName("createdAt")
    val createdAt: String
)
