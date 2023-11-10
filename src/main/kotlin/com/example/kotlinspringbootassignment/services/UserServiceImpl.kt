package com.example.kotlinspringbootassignment.services

import com.example.kotlinspringbootassignment.dtos.UserDto
import com.example.kotlinspringbootassignment.entities.UserEntity
import com.example.kotlinspringbootassignment.repositories.UserRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    @Autowired private val userRepository: UserRepository,
)
    : UserService {
    override fun addUser(userDto: UserDto) {
        val objectMapper = ObjectMapper()
        val userEntity = objectMapper.convertValue(userDto, UserEntity::class.java)
        userRepository.save(userEntity);
    }

    override fun addAllUsers(usersList: MutableList<UserEntity>) {
        userRepository.saveAll(usersList);
    }


}