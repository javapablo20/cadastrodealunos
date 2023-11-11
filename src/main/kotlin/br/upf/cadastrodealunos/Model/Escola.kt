package br.upf.cadastrodealunos.Model

import jakarta.persistence.*

data class Escola(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    val nome: String,
    @ManyToOne
    val cidade: String,
    @ManyToOne
    val estado: String,
    @Enumerated
    val tipo: TipoEscola
)
