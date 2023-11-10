package com.example.kotlinspringbootassignment.repositories

import com.example.kotlinspringbootassignment.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<UserEntity, UUID> {
    //fun findByTeamId(id: UUID?): Any
    //fun updateUserEntitiesByRole(teamLeadId: UUID?, s:Enum<Role>)

}