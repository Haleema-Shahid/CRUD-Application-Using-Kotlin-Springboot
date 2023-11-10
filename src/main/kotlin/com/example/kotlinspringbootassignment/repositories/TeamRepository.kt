package com.example.kotlinspringbootassignment.repositories

import com.example.kotlinspringbootassignment.entities.TeamEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TeamRepository: JpaRepository<TeamEntity, UUID> {

}