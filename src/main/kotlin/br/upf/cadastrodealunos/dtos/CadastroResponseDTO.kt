package br.upf.cadastrodealunos.dtos

import br.upf.cadastrodealunos.Model.TipoEscola
import java.time.LocalDate

data class CadastroResponseDTO(
    val matricula: Long?,
    val nome: String,
    val idade: Int,
    val escola: String,
    val tipo: TipoEscola,
    val telefone: String,
    val email: String,
    val data: LocalDate
)
