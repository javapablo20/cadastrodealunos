package br.upf.cadastrodealunos.dtos

import br.upf.cadastrodealunos.Model.TipoEscola
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class CadastroDTO(
    @field:NotEmpty(message = "O cadastro sempre deve ter um nome")
    val nome: String,
    @field:NotNull(message = "O cadastro sempre deve ter uma idade")
    val idade: Int,
    @field:NotEmpty(message = "O cadastro sempre deve ter o nome da escola")
    val escola: String,
    @field:NotNull(message = "O cadastro sempre deve ter a informação sobre a escola")
    val tipo: TipoEscola,
    @field:NotEmpty(message = "O cadastro sempre deve ter um número de telefone")
    val telefone: String,
    @field:NotEmpty(message = "O cadastro sempre deve ter um email")
    val email: String,
    @field:NotNull(message = "O cadastro sempre deve ter uma data")
    val data: LocalDate
)
