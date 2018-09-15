package pl.jurasz.dev.projectmanager.application.team.dto

import pl.jurasz.dev.projectmanager.domain.team.ExistingTeam
import pl.jurasz.dev.projectmanager.domain.team.Team

data class ExistingTeamDto (
        val name: String,
        val currentlyImplementedProjects: Int,
        val busy: Boolean,
        val members: List<TeamMemberDto>
){

    companion object {
        fun mapToExistingTeams(teams: List<Team>) : List<ExistingTeamDto> = teams.map {
            ExistingTeamDto(
                    it.name,
                    it.currentlyImplementedProjects,
                    false,
                    TeamMemberDto.mapToTeamMembers(it.members))
        }
    }

}