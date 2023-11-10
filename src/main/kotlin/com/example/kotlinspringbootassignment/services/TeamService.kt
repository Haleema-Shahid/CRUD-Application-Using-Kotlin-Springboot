package com.example.kotlinspringbootassignment.services

import com.example.kotlinspringbootassignment.dtos.TeamDto
import com.example.kotlinspringbootassignment.entities.TeamEntity
import org.springframework.stereotype.Service

@Service
interface TeamService {
    fun addTeam(teamDto: TeamDto)
    fun addAllTeams(teamsList: MutableList<TeamEntity>)

}