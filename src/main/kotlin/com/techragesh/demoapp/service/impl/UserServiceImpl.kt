package com.techragesh.demoapp.service.impl

import com.techragesh.demoapp.exception.UserNotFoundException
import com.techragesh.demoapp.model.User
import com.techragesh.demoapp.service.UserService
import org.springframework.stereotype.Service
import kotlin.random.Random
import kotlin.random.nextInt


@Service
class UserServiceImpl: UserService {

    override fun getById(id: Int): User {
        return findById(id)
    }

    override fun getUsers(records: Int?): List<User> {
        return records?.let { userMap.values.toList().take(records) }
            ?: userMap.values.toList()
    }

    override fun addUser(user: User): User {
        user.id = Random.nextInt(0 until 9999999)
        userMap[user.id] = user
        return user
    }

    override fun updateUser(id: Int, user: User): User {
        findById(id)
        user.id = id
        userMap[id] = user
        return user
    }

    override fun deleteUserById(id: Int) {
        findById(id)
        userMap.remove(id)
    }

    private fun findById(id: Int) = userMap[id] ?: throw UserNotFoundException("User: $id not found")

    companion object {
        private var user1 = User(1, "ragesh", "ragesh@mail.com")
        private var user2 = User(2, "sharma", "sharma@mail.com")
        private val userMap = hashMapOf(user1.id to user1, user2.id to user2)
    }

}