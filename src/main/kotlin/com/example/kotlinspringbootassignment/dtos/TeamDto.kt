package com.example.kotlinspringbootassignment.dtos;

import java.util.UUID


data class TeamDto(
    val id: UUID?,
    val name: String,
    val teamLeadId: String,
    val teamMemberIds: List<UUID>
){
    constructor() : this(null, "", "", emptyList())
}