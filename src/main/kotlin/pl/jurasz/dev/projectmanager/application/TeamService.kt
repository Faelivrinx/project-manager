package pl.jurasz.dev.projectmanager.application

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus
import pl.jurasz.dev.projectmanager.domain.Team
import pl.jurasz.dev.projectmanager.domain.TeamRepository

@Service
class TeamService(
        val teamRepository: TeamRepository
) {

    fun createTeam(newTeam: NewTeam) {
        val team = Team(newTeam.name)

        if (teamRepository.exist(team.name)){
            throw TeamAlreadyExistException("Team already exists")
        }
        teamRepository.save(team)

    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Team already exists")
    internal class TeamAlreadyExistException(msg: String) : RuntimeException(msg)

}
