package com.example.springapplication.repository.impl

import com.example.springapplication.domain.BankAccount
import com.example.springapplication.repository.BankAccountDao
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Suppress("unused")
private class BankAccountDaoImpl(
    @PersistenceContext
    private val em: EntityManager
) : BankAccountDao {

    override fun generateBankAccounts(count: Long): Iterable<BankAccount> {
        val generatedBankAccounts = (1..count).map { generateRandomBankAccount() }
        generatedBankAccounts.forEach(em::persist)
        return generatedBankAccounts
    }

    override fun deleteAll() {
        em.createQuery("delete from BankAccount").executeUpdate()
        em.flush()
    }

    private fun generateRandomBankAccount(): BankAccount =
        UUID.randomUUID().toString()
            .split("-")
            .toMutableList()
            .apply { removeAt(index = 3) }
            .joinToString(separator = "", prefix = "G")
            .let { BankAccount(iban = it) }
}
