package com.example.springapplication.repository

import com.example.springapplication.domain.BankAccount
import org.springframework.data.repository.CrudRepository

interface BankAccountRepository : CrudRepository<BankAccount, String>, BankAccountDao

interface BankAccountDao {
    fun generateBankAccounts(count: Long): Iterable<BankAccount>
    fun deleteAll()
}
