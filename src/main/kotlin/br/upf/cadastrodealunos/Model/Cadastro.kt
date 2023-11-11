package br.upf.cadastrodealunos.Model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Cadastro(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val matricula: Long? = null,
    val nome: String,
    val idade: Int,
    val escola: String,
    @Enumerated(value = EnumType.STRING)
    val tipo: TipoEscola,
    val telefone: String,
    val email: String,
    val data: LocalDate
) {
    fun add(cadastro: Cadastro) {

    }

    fun remove(cadastro: Cadastro) {

    }
}
