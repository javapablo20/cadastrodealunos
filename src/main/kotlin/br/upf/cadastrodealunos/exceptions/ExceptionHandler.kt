package br.upf.cadastrodealunos.exceptions

import br.upf.cadastrodealunos.dtos.ErrorResponseDTO
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler (MethodArgumentNotValidException:: class)
    @ResponseStatus (HttpStatus. BAD_REQUEST)
    fun handleValidationError (
        exception: MethodArgumentNotValidException ,
        request: HttpServletRequest
    ): ErrorResponseDTO {
        val errorMessage = hashMapOf<String, String>()
        exception. bindingResult.fieldErrors.forEach {
            errorMessage[ it.field] = it.defaultMessage ?: "Erro não identificado"
        }
        return ErrorResponseDTO(
            status = HttpStatus. BAD_REQUEST.value(),
            error = HttpStatus. BAD_REQUEST.name,
            massage = errorMessage.toString() ,
            path = request.servletPath
        )
    }
}