package br.upf.cadastrodealunos.Model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

data class Aluno(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val matricula: Cadastro,
    val nome: Cadastro
)
