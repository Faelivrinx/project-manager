package pl.jurasz.dev.projectmanager.application.team.dto

import pl.jurasz.dev.projectmanager.domain.team.Employee

data class TeamMemberDto (
        val firstName: String,
        val lastName: String,
        val jobPosition: String
){

    companion object {
        fun mapToTeamMember(employee: Employee) : TeamMemberDto = TeamMemberDto(
                employee.firstName,
                employee.lastName,
                employee.jobPosition.toString())

        fun mapToTeamMembers(members: List<Employee>) : List<TeamMemberDto> = members.map {
            mapToTeamMember(it)
        }
    }

}
