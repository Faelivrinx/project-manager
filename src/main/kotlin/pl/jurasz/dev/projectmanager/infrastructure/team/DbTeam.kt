package pl.jurasz.dev.projectmanager.infrastructure.team

import org.springframework.data.annotation.Id
import pl.jurasz.dev.projectmanager.domain.Team


data class DbTeam (
        @Id val name: String
){
    companion object {
        fun fromTeam(team: Team) : DbTeam = DbTeam(team.name)
    }
}