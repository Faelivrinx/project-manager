package pl.jurasz.dev.projectmanager.infrastructure.team

import org.springframework.data.annotation.Id
import pl.jurasz.dev.projectmanager.domain.team.Team


data class DbTeam (
        @Id val name: String,
        val currentImplementedProjects: Int,
        val members: List<DbEmployee>
){
    companion object {
        fun fromTeam(team: Team) : DbTeam = DbTeam(
                team.name,
                team.currentlyImplementedProjects,
                team.members.map { DbEmployee.toDbEmployee(it) })

        fun toTeam(dbTeam: DbTeam) : Team = Team(
                dbTeam.name,
                dbTeam.currentImplementedProjects,
                dbTeam.members.map { DbEmployee.toEmployee(it) }
        )

        fun toTeams(dbTeams: List<DbTeam>) : List<Team> = dbTeams.map {
            DbTeam.toTeam(it)
        }
    }
}