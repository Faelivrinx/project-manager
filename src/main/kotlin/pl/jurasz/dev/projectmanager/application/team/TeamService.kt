package pl.jurasz.dev.projectmanager.application.team

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import pl.jurasz.dev.projectmanager.application.team.dto.ExistingTeamDto
import pl.jurasz.dev.projectmanager.application.team.dto.NewTeamDto
import pl.jurasz.dev.projectmanager.domain.expection.ExceptionThrower
import pl.jurasz.dev.projectmanager.domain.team.Team
import pl.jurasz.dev.projectmanager.domain.team.TeamRepository
import java.lang.invoke.MethodHandles

@Service
class TeamService(
        val teamRepository: TeamRepository
) {

    fun createTeam(newTeam: NewTeamDto) {
        logger.info("Creating new team {} ", newTeam.name)
        if (teamRepository.existByName(newTeam.name)){
        }
        when(teamRepository.existByName(newTeam.name)){
            true -> {
                logger.warn("Team {} already exists.", newTeam.name)
                throw ExceptionThrower()
            }
            false -> {
                val team = Team(newTeam.name)
                teamRepository.save(team)
            }
        }
    }

    fun getTeams(): List<ExistingTeamDto> {
        val teams = teamRepository.findAll()
        return ExistingTeamDto.mapToExistingTeams(teams)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    }


}
