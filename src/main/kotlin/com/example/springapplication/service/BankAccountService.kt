package com.example.springapplication.service

import com.example.springapplication.domain.BankAccount

interface BankAccountService {
    fun save(entity: BankAccount): BankAccount
    fun saveAll(entities: Iterable<BankAccount>): Iterable<BankAccount>
    fun generateBankAccounts(count: Long): Iterable<BankAccount>

    fun findAll(): Iterable<BankAccount>
    fun findAllById(ids: Iterable<String>): Iterable<BankAccount>
    fun findById(id: String): BankAccount?

    fun delete(entity: BankAccount)
    fun deleteAll()
    fun deleteAll(entities: Iterable<BankAccount>)
    fun deleteAllById(ids: Iterable<String>)
    fun deleteById(id: String)

    fun count(): Long
    fun existsById(id: String): Boolean
}
