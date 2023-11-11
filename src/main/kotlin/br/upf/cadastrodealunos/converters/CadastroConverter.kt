package br.upf.cadastrodealunos.converters

import br.upf.cadastrodealunos.Model.Cadastro
import br.upf.cadastrodealunos.dtos.CadastroDTO
import br.upf.cadastrodealunos.dtos.CadastroResponseDTO
import org.springframework.stereotype.Component

@Component
class CadastroConverter {
    fun toCadastro(dto: CadastroDTO): Cadastro {
        return Cadastro(
            nome = dto.nome,
            idade = dto.idade,
            escola = dto.escola,
            tipo = dto.tipo,
            telefone = dto.telefone,
            email = dto.email,
            data = dto.data
        )
    }

    fun toCadastroResponseDTO(cadastro: Cadastro): CadastroResponseDTO {
        return CadastroResponseDTO(
            matricula = cadastro.matricula,
            nome = cadastro.nome,
            idade = cadastro.idade,
            escola = cadastro.escola,
            tipo = cadastro.tipo,
            telefone = cadastro.telefone,
            email = cadastro.email,
            data = cadastro.data
        )
    }
}