package com.example.kotlinspringbootassignment.services

import com.example.kotlinspringbootassignment.dtos.UserDto
import com.example.kotlinspringbootassignment.entities.UserEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
interface UserService {
    fun addUser(userDto: UserDto)
    fun addAllUsers(usersList: MutableList<UserEntity>)
    fun assignRoles()
    fun assignTesterRoleTo(userId: UUID): UserEntity

}