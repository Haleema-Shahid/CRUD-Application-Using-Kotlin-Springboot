package com.example.kotlinspringbootassignment.controllers

import com.example.kotlinspringbootassignment.dtos.TeamDto
import com.example.kotlinspringbootassignment.dtos.UserDto
import com.example.kotlinspringbootassignment.entities.TeamEntity
import com.example.kotlinspringbootassignment.entities.UserEntity
import com.example.kotlinspringbootassignment.services.TeamService
import com.example.kotlinspringbootassignment.services.UserService
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.util.*

@RestController
class Controller(
    @Autowired private val userService: UserService,
    @Autowired private val teamService: TeamService
) {

    fun fetchUsers(): List<UserDto> {
        val restTemplate = RestTemplate()
        val responseEntity: ResponseEntity<String> = restTemplate.getForEntity("https://cgjresszgg.execute-api.eu-west-1.amazonaws.com/users/", String::class.java)
        val json = responseEntity.body ?: return emptyList()

        val objectMapper = ObjectMapper()
        val typeReference = object : TypeReference<List<UserDto>>() {}
        return objectMapper.readValue(json, typeReference)
    }

    fun fetchTeams(): List<TeamDto> {
        val restTemplate = RestTemplate()
        val responseEntity: ResponseEntity<String> = restTemplate.getForEntity("https://cgjresszgg.execute-api.eu-west-1.amazonaws.com/teams/", String::class.java)
        val json = responseEntity.body ?: return emptyList()

        val objectMapper = ObjectMapper()
        val typeReference = object : TypeReference<List<TeamDto>>() {}
        return objectMapper.readValue(json, typeReference)
    }

    fun fetchUser(id: UUID?): UserDto {
        val restTemplate = RestTemplate()
        val responseEntity: ResponseEntity<String> = restTemplate.getForEntity("https://cgjresszgg.execute-api.eu-west-1.amazonaws.com/users/${id}", String::class.java)
        val json = responseEntity.body ?: return UserDto()

        val objectMapper = ObjectMapper()
        val typeReference = object : TypeReference<UserDto>() {}
        return objectMapper.readValue(json, typeReference)
    }

    fun fetchTeam(id: UUID?): TeamDto {
        val restTemplate = RestTemplate()
        val responseEntity: ResponseEntity<String> = restTemplate.getForEntity("https://cgjresszgg.execute-api.eu-west-1.amazonaws.com/teams/${id}", String::class.java)
        val json = responseEntity.body ?: return TeamDto()

        val objectMapper = ObjectMapper()
        val typeReference = object : TypeReference<TeamDto>() {}
        return objectMapper.readValue(json, typeReference)
    }

//
    @GetMapping("/load")
    fun loadData(): String{
        val usersFromApi = fetchUsers()
        val teamsFromApi = fetchTeams()


        val usersList = mutableListOf<UserEntity>()
        for(userDto in usersFromApi){
            var objectMapper = ObjectMapper()
            val fetchedUserFromApi = fetchUser(userDto.id)
            usersList.add(objectMapper.convertValue(fetchedUserFromApi, UserEntity::class.java))
//            userService.addUser(fetchedUserFromApi);
        }

        userService.addAllUsers(usersList)

        val teamsList = mutableListOf<TeamEntity>()
        for(teamDto in teamsFromApi){
            var objectMapper = ObjectMapper()
            val fetchedTeamFromApi = fetchTeam(teamDto.id)
            teamsList.add(objectMapper.convertValue(fetchedTeamFromApi, TeamEntity::class.java))
    //            userService.addUser(fetchedUserFromApi);
        }

        teamService.addAllTeams(teamsList)
        return "done"
    }

    @GetMapping("/assignRoles")
    fun assignRoles(): ResponseEntity<String> {
        return try {
            userService.assignRoles()
            ResponseEntity("assigned roles successfully!", HttpStatus.OK)
        }
        catch (e:Exception){
            ResponseEntity("assignment of roles failed!", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PostMapping("/assignTesterRoleTo/{userId}")
    fun assignTesterRoleToUser(@PathVariable userId: UUID): ResponseEntity<String>{
        return try{
            val tester: UserEntity = userService.assignTesterRoleTo(userId)
            ResponseEntity("role assigned succesfully!"+"\nUserId: "+tester.id+"\nRole: "+tester.role, HttpStatus.OK)
        }
        catch(e: Exception){
            ResponseEntity("Tester assignment failed!", HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }





}