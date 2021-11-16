package com.example.springapplication

import com.example.springapplication.service.BankAccountService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    val context = runApplication<Application>(*args)
    val rep = context.getBean(BankAccountService::class.java)

    rep.deleteAll()
    rep.generateBankAccounts(10).forEach(::println)
    println()
    rep.findAll().forEach(::println)
}
