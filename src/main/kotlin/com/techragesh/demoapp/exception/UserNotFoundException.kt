package com.techragesh.demoapp.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="User not found")
class UserNotFoundException(override val message: String?): RuntimeException() {
}