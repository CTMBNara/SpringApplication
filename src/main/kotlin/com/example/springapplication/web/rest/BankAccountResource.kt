package com.example.springapplication.web.rest

import com.example.springapplication.domain.BankAccount
import com.example.springapplication.service.BankAccountService
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bank-accounts")
@Suppress("unused")
class BankAccountResource(
    private val bankAccountService: BankAccountService
) {

    @GetMapping
    suspend fun findAll(): Flow<BankAccount> =
        bankAccountService.findAll()

    @GetMapping("/generate/{count}")
    suspend fun generateBankAccounts(@PathVariable count: Long): Flow<BankAccount> =
        bankAccountService.generateBankAccounts(count)
}
