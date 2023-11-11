package br.upf.cadastrodealunos.dtos

import java.time.LocalDateTime

data class ErrorResponseDTO(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val massage: String,
    val  path: String
)
