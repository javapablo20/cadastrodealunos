package br.upf.cadastrodealunos.Service

import br.upf.cadastrodealunos.Model.Cadastro
import br.upf.cadastrodealunos.Model.TipoEscola
import br.upf.cadastrodealunos.Repository.CadastroRepository
import br.upf.cadastrodealunos.converters.CadastroConverter
import br.upf.cadastrodealunos.dtos.CadastroDTO
import br.upf.cadastrodealunos.dtos.CadastroResponseDTO
import br.upf.cadastrodealunos.exceptions.NotFoundException
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class CadastroService(private val repository: CadastroRepository,
    private val converter: CadastroConverter) {

    fun listar(): List<CadastroResponseDTO> {
        return repository.findAll()
            .map(converter::toCadastroResponseDTO)
    }

    fun buscarPorId(matricula: Long): CadastroResponseDTO {
        val cadastro = repository.findAll().firstOrNull {it.matricula == matricula}
            ?: throw NotFoundException("Evento não encontrado!")
        return converter.toCadastroResponseDTO(cadastro)
    }

    fun cadastrar(dto: CadastroDTO): CadastroResponseDTO {
       val cadastro = repository.cadastrar(converter.toCadastro(dto))
        return converter.toCadastroResponseDTO(cadastro)
    }

    fun atualizar(matricula: Long, dto: CadastroDTO): CadastroResponseDTO {
        val cadastro = repository.findAll().firstOrNull {it.matricula == matricula}
            ?: throw NotFoundException("Evento não encontrado!")
      val cadastroAtualizado = repository.update(cadastro, converter.toCadastro(dto))
        return converter.toCadastroResponseDTO(cadastroAtualizado)
    }

    fun deletar(matricula: Long) {
        repository.deletar(matricula)
    }

    companion object {
        private const val EVENT_NOT_FOUND_MESSAGE = "Evento não encontrado!"
    }

}