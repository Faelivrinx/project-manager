package pl.jurasz.dev.projectmanager.domain.team

import pl.jurasz.dev.projectmanager.domain.team.Team

interface TeamRepository {
    fun existByName(id: String) : Boolean
    fun save(team: Team)
    fun findAll() : List<Team>
}