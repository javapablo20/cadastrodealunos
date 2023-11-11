package br.upf.cadastrodealunos.Controller

import br.upf.cadastrodealunos.Model.Cadastro
import br.upf.cadastrodealunos.Service.CadastroService
import br.upf.cadastrodealunos.dtos.CadastroDTO
import br.upf.cadastrodealunos.dtos.CadastroResponseDTO
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/cadastro" )
class CadastroController(val service: CadastroService) {

    @GetMapping
    fun listar(): List<CadastroResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{matricula}")
    fun buscarPorId(@PathVariable matricula: Long): CadastroResponseDTO {
        return service.buscarPorId(matricula)
    }

    @PostMapping
    fun cadastra(@RequestBody @Valid dto: CadastroDTO,
                uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CadastroResponseDTO> {
        val cadastroResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/cadastro/${cadastroResponse.matricula}")
            .build().toUri()
        return ResponseEntity.created(uri).body(cadastroResponse)
    }

    @PutMapping("/{matricula}")
    fun atualizar(@PathVariable matricula: Long,
                  @RequestBody @Valid dto: CadastroDTO
    ): CadastroResponseDTO {
       return service.atualizar(matricula, dto)
    }

    @DeleteMapping("/{matricula}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable matricula: Long) {
        service.deletar(matricula)
    }

}