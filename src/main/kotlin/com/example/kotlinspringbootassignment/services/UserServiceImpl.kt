package com.example.kotlinspringbootassignment.services

import com.example.kotlinspringbootassignment.dtos.UserDto
import com.example.kotlinspringbootassignment.entities.UserEntity
import com.example.kotlinspringbootassignment.enums.Role
import com.example.kotlinspringbootassignment.repositories.TeamRepository
import com.example.kotlinspringbootassignment.repositories.UserRepository
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
        @Autowired private val userRepository: UserRepository,
        @Autowired private val teamRepository: TeamRepository,

        ) : UserService {
    override fun addUser(userDto: UserDto) {
        val objectMapper = ObjectMapper()
        val userEntity = objectMapper.convertValue(userDto, UserEntity::class.java)
        userRepository.save(userEntity)
    }

    override fun addAllUsers(usersList: MutableList<UserEntity>) {
        userRepository.saveAll(usersList)
    }

    @Transactional
    override fun assignRoles() {
        // Fetch all teams
        val teams = teamRepository.findAll()

        teams.forEach { team ->
            // Find team lead for each team
            val teamLeadId = team.teamLeadId
            // Assign "Product Owner" role to the team lead
            if (teamLeadId != null) {
                val user: Optional<UserEntity> = userRepository.findById(teamLeadId as UUID)
                user.get().role=Role.PRODUCTOWNER
                userRepository.save(user.get());
            }
        }
    }

    override fun assignTesterRoleTo(userId: UUID): UserEntity {
        // Find user by userId
        val userOptional = userRepository.findById(userId)

        if (userOptional.isPresent) {
            // Update user role to "tester"
            val user = userOptional.get()
            user.role = Role.TESTER

            // Save the updated user
            return userRepository.save(user)
        } else {
            // Handle the case when the user with the given userId is not found
            throw NoSuchElementException("User with ID $userId not found")
        }
    }
}


