package pl.jurasz.dev.projectmanager.domain.team

import org.apache.commons.lang3.StringUtils.isBlank
import pl.jurasz.dev.projectmanager.domain.expection.ErrorCode
import pl.jurasz.dev.projectmanager.domain.expection.InvalidEntityException

data class Team ( val name: String,
                  val currentlyImplementedProjects: Int = 0,
                  val members: List<Employee> = emptyList()){
    init {
        validateName(name)
    }

    private fun validateName(name: String) {
        when(isBlank(name)){
            true ->  throw InvalidEntityException(ErrorCode.EMPTY_TEAM_NAME)
        }
    }
}