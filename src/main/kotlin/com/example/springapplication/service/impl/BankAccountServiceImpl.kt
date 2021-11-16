package com.example.springapplication.service.impl

import com.example.springapplication.domain.BankAccount
import com.example.springapplication.repository.BankAccountRepository
import com.example.springapplication.service.BankAccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BankAccountServiceImpl @Autowired constructor(
    private val bankAccountRepository: BankAccountRepository
) : BankAccountService {
    override fun save(entity: BankAccount): BankAccount =
        bankAccountRepository.save(entity)

    override fun saveAll(entities: Iterable<BankAccount>): Iterable<BankAccount> =
        bankAccountRepository.saveAll(entities)

    override fun generateBankAccounts(count: Long): Iterable<BankAccount> =
        bankAccountRepository.generateBankAccounts(count)

    @Transactional(readOnly = true)
    override fun findAll(): Iterable<BankAccount> =
        bankAccountRepository.findAll()

    @Transactional(readOnly = true)
    override fun findAllById(ids: Iterable<String>): Iterable<BankAccount> =
        bankAccountRepository.findAllById(ids)

    @Transactional(readOnly = true)
    override fun findById(id: String): BankAccount? =
        bankAccountRepository.findById(id).orElse(null)

    override fun delete(entity: BankAccount): Unit =
        bankAccountRepository.delete(entity)

    override fun deleteAll(): Unit =
        bankAccountRepository.deleteAll()

    override fun deleteAll(entities: Iterable<BankAccount>): Unit =
        bankAccountRepository.deleteAll(entities)

    override fun deleteAllById(ids: Iterable<String>): Unit =
        bankAccountRepository.deleteAllById(ids)

    override fun deleteById(id: String): Unit =
        bankAccountRepository.deleteById(id)

    @Transactional(readOnly = true)
    override fun count(): Long =
        bankAccountRepository.count()

    @Transactional(readOnly = true)
    override fun existsById(id: String): Boolean =
        bankAccountRepository.existsById(id)
}
