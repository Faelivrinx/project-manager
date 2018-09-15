package pl.jurasz.dev.projectmanager.application.team

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ResponseStatus
import pl.jurasz.dev.projectmanager.application.team.dto.ExistingTeamDto
import pl.jurasz.dev.projectmanager.application.team.dto.NewTeamDto
import pl.jurasz.dev.projectmanager.domain.team.Team
import pl.jurasz.dev.projectmanager.domain.team.TeamRepository

@Service
class TeamService(
        val teamRepository: TeamRepository
) {

    fun createTeam(newTeam: NewTeamDto) {
        val team = Team(newTeam.name)

        if (teamRepository.exist(team.name)){
            throw TeamAlreadyExistException("Team already exists")
        }
        teamRepository.save(team)

    }

    fun getTeams(): List<ExistingTeamDto> {
        val teams = teamRepository.findAll()
        return ExistingTeamDto.mapToExistingTeams(teams)
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Team already exists")
    internal class TeamAlreadyExistException(msg: String) : RuntimeException(msg)

}
