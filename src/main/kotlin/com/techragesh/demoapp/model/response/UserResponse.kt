package com.techragesh.demoapp.model.response

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

class UserResponse<T> @JsonCreator constructor(
    @param:JsonProperty("success")
    val isSuccess: Boolean,
    @param:JsonProperty("payload")
    val payload: T?,
    @param:JsonProperty("message")
    val message: String?,
){
    companion object {
        fun <T> success(payload: T? = null, message: String? = null): UserResponse<T> {
            return UserResponse(true, payload, message)
        }

        fun <T> fail(payload: T? = null, message: String? = null): UserResponse<T> {
            return UserResponse(false, payload, message)
        }
    }
}