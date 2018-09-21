package pl.jurasz.dev.projectmanager.domain.project

import org.springframework.data.annotation.Id

data class Project (
        @Id val id: String,
        val name: String,
        val assignedTeam: String?,
        val features: List<Feature>

){
}