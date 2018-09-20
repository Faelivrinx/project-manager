package pl.jurasz.dev.projectmanager.application.team

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import pl.jurasz.dev.projectmanager.application.team.dto.ExistingTeamDto
import pl.jurasz.dev.projectmanager.application.team.dto.NewTeamDto
import pl.jurasz.dev.projectmanager.application.team.dto.TeamMemberDto
import pl.jurasz.dev.projectmanager.domain.expection.EntityAlreadyExistException
import pl.jurasz.dev.projectmanager.domain.expection.ErrorCode
import pl.jurasz.dev.projectmanager.domain.expection.MissingEntityException
import pl.jurasz.dev.projectmanager.domain.team.Employee
import pl.jurasz.dev.projectmanager.domain.team.Team
import pl.jurasz.dev.projectmanager.domain.team.TeamRepository
import java.lang.invoke.MethodHandles

@Service
class TeamService(
        val teamRepository: TeamRepository
) {

    fun createTeam(newTeam: NewTeamDto) {
        logger.info("Creating new team {} ", newTeam.name)
        when(teamRepository.existByName(newTeam.name)){
            true -> throw EntityAlreadyExistException(ErrorCode.TEAM_ALREADY_EXISTS)
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

    fun addTeamMember(teamName: String, teamMember: TeamMemberDto) {
        teamRepository.findByName(teamName) ?: throw MissingEntityException(ErrorCode.NON_EXISTING_TEAM)

        val team = Team(teamName)
        Employee.toEmployee(teamMember).apply { team.addMember(this) }
        teamRepository.save(team)
    }


    companion object {
        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    }


}
