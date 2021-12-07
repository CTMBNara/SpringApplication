package com.example.springapplication.repository

import com.example.springapplication.domain.BankAccount
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BankAccountRepository : CoroutineCrudRepository<BankAccount, String>

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun BankAccountRepository.generateBankAccounts(count: Long): Flow<BankAccount> = channelFlow {
    withContext(Dispatchers.IO) {
        for (i in 1..count) {
            launch {
                val bankAccount = generateRandomBankAccount()
                send(save(bankAccount))
            }
        }
    }
}

private fun generateRandomBankAccount(): BankAccount =
    UUID.randomUUID().toString()
        .split("-")
        .toMutableList()
        .apply { removeAt(index = 3) }
        .joinToString(separator = "", prefix = "G")
        .let { BankAccount(iban = it) }
