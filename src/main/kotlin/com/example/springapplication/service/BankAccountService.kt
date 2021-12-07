package com.example.springapplication.service

import com.example.springapplication.domain.BankAccount
import kotlinx.coroutines.flow.Flow

interface BankAccountService {
    suspend fun save(entity: BankAccount): BankAccount
    suspend fun saveAll(entities: Iterable<BankAccount>): Flow<BankAccount>
    suspend fun generateBankAccounts(count: Long): Flow<BankAccount>

    suspend fun findAll(): Flow<BankAccount>
    suspend fun findAllById(ids: Iterable<String>): Flow<BankAccount>
    suspend fun findById(id: String): BankAccount?

    suspend fun delete(entity: BankAccount)
    suspend fun deleteAll()
    suspend fun deleteAll(entities: Iterable<BankAccount>)
    suspend fun deleteAllById(ids: Iterable<String>)
    suspend fun deleteById(id: String)

    suspend fun count(): Long
    suspend fun existsById(id: String): Boolean
}
