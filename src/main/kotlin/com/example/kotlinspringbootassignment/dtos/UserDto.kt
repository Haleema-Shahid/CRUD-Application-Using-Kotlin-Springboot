package com.example.kotlinspringbootassignment.dtos

import java.util.UUID


data class UserDto(
    val id: UUID?,
    val firstName: String,
    val lastName: String,
    val displayName: String,
    val avatarUrl: String,
    val location: String
){
    constructor() : this(null, "", "", "", "", "")
}
