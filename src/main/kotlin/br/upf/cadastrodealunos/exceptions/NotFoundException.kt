package br.upf.cadastrodealunos.exceptions

class NotFoundException(override val message: String)
    : RuntimeException()