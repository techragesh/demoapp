package com.techragesh.demoapp.exception

import com.techragesh.demoapp.model.response.UserResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.stream.Collectors

@ControllerAdvice
internal class UserControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleNotValidException(exception: MethodArgumentNotValidException): ResponseEntity<UserResponse<Any>> {
        val message = exception.bindingResult.fieldErrors.stream().map { it.defaultMessage }.collect(Collectors.joining(", "))
        return ResponseEntity.badRequest().body(UserResponse.fail(message = message))
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(exception: UserNotFoundException): ResponseEntity<UserResponse<Any>> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(UserResponse.fail(message = exception.message))
    }
}