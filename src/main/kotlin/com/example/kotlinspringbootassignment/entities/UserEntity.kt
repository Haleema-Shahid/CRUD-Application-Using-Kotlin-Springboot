package com.example.kotlinspringbootassignment.entities

import com.example.kotlinspringbootassignment.enums.Role
import jakarta.persistence.*
import java.util.*


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
        var role: Enum<Role> = Role.DEVELOPER,
        val firstName: String="",
        val lastName: String="",
        val displayName: String="",
        val avatarUrl: String="",
        val location: String="",
){

}
