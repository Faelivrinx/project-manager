package pl.jurasz.dev.projectmanager.domain.team

import pl.jurasz.dev.projectmanager.application.team.dto.TeamMemberDto

data class ExistingTeam (
        val name: String,
        val currentlyImplementedProjects: Int,
        val busy: Boolean,
        val members: List<TeamMemberDto>
){
    companion object {
        fun mapToExistingTeam(team: Team) : ExistingTeam = ExistingTeam(
                team.name,
                team.currentlyImplementedProjects,
                false, //TODO
                team.members.map { TeamMemberDto.mapToTeamMember(it) }
        )
    }
}