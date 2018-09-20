package pl.jurasz.dev.projectmanager.domain.team

import org.apache.commons.lang3.StringUtils.isBlank
import pl.jurasz.dev.projectmanager.application.team.dto.TeamMemberDto
import pl.jurasz.dev.projectmanager.domain.expection.ErrorCode
import pl.jurasz.dev.projectmanager.domain.expection.ErrorCode.*
import pl.jurasz.dev.projectmanager.domain.expection.InvalidEntityException

data class Team ( val name: String,
                  val currentlyImplementedProjects: Int = 0,
                  val members: MutableList<Employee> = mutableListOf()){
    init {
        validateName(name)
    }

    private fun validateName(name: String) {
        when(isBlank(name)){
            true ->  throw InvalidEntityException(ErrorCode.EMPTY_TEAM_NAME)
        }
    }

    fun addMember(teamMember: Employee){
        validateMember(teamMember)
        members.add(teamMember)
    }

    fun validateMember(teamMember: Employee) {
        if (teamMember.hasNoFirstName()){
            throw InvalidEntityException(EMPTY_MEMBER_FIRST_NAME)
        }
        if(teamMember.hasNoLastName()){
            throw  InvalidEntityException(EMPTY_MEMBER_LAST_NAME)
        }
        if(teamMember.hasInvalidJobPosition()){
            throw InvalidEntityException(EMPTY_OR_INVALID_MEMBER_JOB_POSITION)
        }
    }

    fun isBusy(): Boolean = currentlyImplementedProjects > THRESHOLD_BUSY_TEAM

    companion object {
        private const val THRESHOLD_BUSY_TEAM = 3
    }
}