package com.techragesh.demoapp.model

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class User(
    var id: Int,
    @field: NotBlank(message = "Name cannot be blank")
    var name: String?,
    @field: Email(message = "Email cannot be blank")
    var email: String?,
    var city: String? = null
)
