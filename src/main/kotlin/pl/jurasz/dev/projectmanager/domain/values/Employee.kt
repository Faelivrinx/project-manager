package pl.jurasz.dev.projectmanager.domain.values

import org.apache.commons.lang3.StringUtils.isBlank
import pl.jurasz.dev.projectmanager.application.team.dto.TeamMemberDto

data class Employee(
        val firstName: String,
        val lastName: String,
        val jobPosition: JobPosition
){

    fun hasNoFirstName(): Boolean = isBlank(firstName)
    fun hasNoLastName(): Boolean = isBlank(lastName)
    fun hasInvalidJobPosition(): Boolean = this.jobPosition.isInvalid()

    companion object {
        fun toEmployee(teamMember: TeamMemberDto) = Employee(
                teamMember.firstName,
                teamMember.lastName,
                toJobPosition(teamMember.jobPosition)
        )

        fun toJobPosition(jobString: String): JobPosition {
            return try {
                JobPosition.valueOf(jobString)
            } catch (e: IllegalArgumentException){
                JobPosition.INVALID
            }
        }
    }
}



