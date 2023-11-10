package com.example.kotlinspringbootassignment.services

import com.example.kotlinspringbootassignment.dtos.TeamDto
import com.example.kotlinspringbootassignment.entities.TeamEntity
import com.example.kotlinspringbootassignment.entities.UserEntity
import com.example.kotlinspringbootassignment.repositories.TeamRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TeamServiceImpl(
    @Autowired private val teamRepository: TeamRepository
)
    : TeamService {
    override fun addTeam(teamDto: TeamDto) {
        val objectMapper = ObjectMapper()
        val teamEntity = objectMapper.convertValue(teamDto, TeamEntity::class.java)
        teamRepository.save(teamEntity);
    }

    override fun addAllTeams(teamsList: MutableList<TeamEntity>) {
        teamRepository.saveAll(teamsList)
    }

}