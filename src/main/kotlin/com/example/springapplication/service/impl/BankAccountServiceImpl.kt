package com.example.springapplication.service.impl

import com.example.springapplication.domain.BankAccount
import com.example.springapplication.repository.BankAccountRepository
import com.example.springapplication.repository.generateBankAccounts
import com.example.springapplication.service.BankAccountService
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BankAccountServiceImpl @Autowired constructor(
    private val bankAccountRepository: BankAccountRepository
) : BankAccountService {
    override suspend fun save(entity: BankAccount): BankAccount =
        bankAccountRepository.save(entity)

    override suspend fun saveAll(entities: Iterable<BankAccount>): Flow<BankAccount> =
        bankAccountRepository.saveAll(entities)

    override suspend fun generateBankAccounts(count: Long): Flow<BankAccount> =
        bankAccountRepository.generateBankAccounts(count)

    @Transactional(readOnly = true)
    override suspend fun findAll(): Flow<BankAccount> =
        bankAccountRepository.findAll()

    @Transactional(readOnly = true)
    override suspend fun findAllById(ids: Iterable<String>): Flow<BankAccount> =
        bankAccountRepository.findAllById(ids)

    @Transactional(readOnly = true)
    override suspend fun findById(id: String): BankAccount? =
        bankAccountRepository.findById(id)

    override suspend fun delete(entity: BankAccount): Unit =
        bankAccountRepository.delete(entity)

    override suspend fun deleteAll(): Unit =
        bankAccountRepository.deleteAll()

    override suspend fun deleteAll(entities: Iterable<BankAccount>): Unit =
        bankAccountRepository.deleteAll(entities)

    override suspend fun deleteAllById(ids: Iterable<String>): Unit =
        bankAccountRepository.deleteAllById(ids)

    override suspend fun deleteById(id: String): Unit =
        bankAccountRepository.deleteById(id)

    @Transactional(readOnly = true)
    override suspend fun count(): Long =
        bankAccountRepository.count()

    @Transactional(readOnly = true)
    override suspend fun existsById(id: String): Boolean =
        bankAccountRepository.existsById(id)
}
