package com.example.springapplication

import com.example.springapplication.service.BankAccountService
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>): Unit = runBlocking {
    val context = runApplication<Application>(*args)
    val rep = context.getBean(BankAccountService::class.java)

    rep.deleteAll()
    rep.generateBankAccounts(10).collect { println(it) }
    println()
    rep.findAll().collect { println(it) }
}
