package com.example.kotlinspringbootassignment.entities

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.util.UUID


@Entity
@Table(name = "`user`")
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    val firstName: String="",
    val lastName: String="",
    val displayName: String="",
    val avatarUrl: String="",
    val location: String=""
){

}
