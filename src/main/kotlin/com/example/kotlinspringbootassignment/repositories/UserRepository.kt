package com.example.kotlinspringbootassignment.repositories

import com.example.kotlinspringbootassignment.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository: JpaRepository<UserEntity, UUID> {

}