package com.example.springapplication.domain

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(name = "bank_account_v2")
data class BankAccount(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val iban: String
) {
    init {
        require(iban.length <= 29) { "Invalid iban." }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as BankAccount

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , iban = $iban )"
    }
}
