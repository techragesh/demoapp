package com.techragesh.demoapp.controller

import com.techragesh.demoapp.model.User
import com.techragesh.demoapp.model.response.UserResponse
import com.techragesh.demoapp.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/users")
class UserController(private val userService: UserService) {

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") id: Int): UserResponse<User> {
        val user = userService.getById(id)
        return UserResponse.success(payload = user)
    }


    @GetMapping
    fun getUsers(
        @RequestParam(required = false) records: Int?
    ): UserResponse<List<User>> {
        val users = userService.getUsers(records)
        return UserResponse.success(payload = users)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addUser(@Valid @RequestBody user: User): UserResponse<User> {
        val user = userService.addUser(user)
        return UserResponse.success(payload = user)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Int, @RequestBody user: User): User {
        return userService.updateUser(id, user)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUserById(@PathVariable id: Int) {
        userService.deleteUserById(id)
    }
}