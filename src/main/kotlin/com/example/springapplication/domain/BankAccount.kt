package com.example.springapplication.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(value = "bank_account_v2")
data class BankAccount(
    @Id
    var id: Long? = null,

    val iban: String
) {
    init {
        require(iban.length <= 29) { "Invalid iban." }
    }
}
