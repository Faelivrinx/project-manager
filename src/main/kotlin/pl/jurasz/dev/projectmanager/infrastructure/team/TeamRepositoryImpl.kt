package pl.jurasz.dev.projectmanager.infrastructure.team

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import pl.jurasz.dev.projectmanager.domain.team.Team
import pl.jurasz.dev.projectmanager.domain.team.TeamRepository

@Component
class TeamRepositoryImpl (
        val dbTeamRepository: DbTeamRepository
) : TeamRepository {

    override fun save(team: Team) {
        val dbTeam = DbTeam.fromTeam(team)
        dbTeamRepository.save(dbTeam)
    }

    override fun exist(id: String): Boolean {
        return dbTeamRepository.existsById(id)
    }

    override fun findAll(): List<Team> {
        val dbTeams = dbTeamRepository.findAll()
        return DbTeam.toTeams(dbTeams)
    }

}

@Repository
interface DbTeamRepository: MongoRepository<DbTeam, String>