package pl.jurasz.dev.projectmanager.domain.team

import pl.jurasz.dev.projectmanager.domain.team.Team

interface TeamRepository {
    fun exist(id: String) : Boolean
    fun save(team: Team)
    fun findAll() : List<Team>
}