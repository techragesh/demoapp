package com.techragesh.demoapp.service

import com.techragesh.demoapp.model.User

interface UserService {
    fun getById(id: Int): User
    fun getUsers(records: Int?): List<User>
    fun addUser(user: User): User
    fun updateUser(id: Int, user: User): User
    fun deleteUserById(id: Int)
}