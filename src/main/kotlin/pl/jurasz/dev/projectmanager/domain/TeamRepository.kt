package pl.jurasz.dev.projectmanager.domain

interface TeamRepository {
    fun exist(id: String) : Boolean
    fun save(team: Team)
}