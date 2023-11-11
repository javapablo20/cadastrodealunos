package br.upf.cadastrodealunos.Repository

import br.upf.cadastrodealunos.Model.Aluno
import br.upf.cadastrodealunos.Model.Cadastro
import br.upf.cadastrodealunos.Model.Escola
import br.upf.cadastrodealunos.Model.TipoEscola
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class CadastroRepository(private var cadastro: MutableList<Cadastro>) {
    init {
        val hoje = LocalDate.now()
        val cadastro0 = Cadastro(
            matricula = 1,
            nome = "Pablo da Rocha Oliveira",
            idade = 17,
            escola = "Escola Estadual de Ensino Médio Paulo Frontin",
            tipo = TipoEscola.ESTADUAL,
            telefone = "054 99980 5588",
            email = "pablodarocha17@gmail.com",
            data = hoje
        )
        val cadastro1 = Cadastro(
            matricula = 2,
            nome = "Alison Martins",
            idade = 15,
            escola = "Escola Municipal de Ensino Fundamental Getúlio Vargas",
            tipo = TipoEscola.MUNICIPAL,
            telefone = "054 99933 9498",
            email = "alison360@gmail.com",
            data = hoje
        )
        val cadastro2 = Cadastro(
            matricula = 3,
            nome = "Jéssica Gomes da Silva",
            idade = 17,
            escola = "Escola Estadual Princesa Isabel",
            tipo = TipoEscola.ESTADUAL,
            telefone = "054 98448 6829",
            email = "jegomes17@gmail.com",
            data = hoje
        )
        cadastro = mutableListOf(cadastro0, cadastro1, cadastro2)
    }
    fun findAll() = cadastro

    private var idCont = 4L

    fun cadastrar(cadastro: Cadastro): Cadastro {
        val cadastroComMatricula = cadastro.copy(matricula = idCont++)
        cadastro.add(cadastroComMatricula)
        return cadastroComMatricula
    }

    fun update(cadastro: Cadastro, cadastroAtualizado: Cadastro): Cadastro {
        cadastro.remove(cadastro)
        val cadastroAtualizadoComMatricula = Cadastro(
            matricula = cadastro.matricula,
            nome = cadastroAtualizado.nome,
            idade = cadastroAtualizado.idade,
            escola = cadastroAtualizado.escola,
            tipo = cadastroAtualizado.tipo,
            telefone = cadastroAtualizado.telefone,
            email = cadastroAtualizado.email,
            data = cadastroAtualizado.data
        )
        cadastro.add(
           cadastroAtualizadoComMatricula
        )
        return cadastroAtualizadoComMatricula
    }

    fun deletar(matricula: Long) {
        val cadastro = cadastro.first { it.matricula == matricula }
        cadastro.remove(cadastro)
    }

}