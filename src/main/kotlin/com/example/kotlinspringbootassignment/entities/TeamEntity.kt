package com.example.kotlinspringbootassignment.entities

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.util.UUID

@Entity
@Table(name = "team")
data class TeamEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null, // Changed UUID to nullable

    val name: String="",
    val teamLeadId: String="",

    @ElementCollection
    val teamMemberIds: List<UUID> = emptyList(),
)
