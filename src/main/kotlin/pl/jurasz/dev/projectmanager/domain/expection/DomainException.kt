package pl.jurasz.dev.projectmanager.domain.expection

abstract class DomainException(
        val msg: String,
        val errorCode: ErrorCode
)

enum class ErrorCode{
    UNEXPECTED_ERROR,

    EMPTY_TEAM_NAME,
    TEAM_ALREADY_EXISTS,
    NON_EXISTING_TEAM,
    EMPTY_MEMBER_FIRST_NAME,
    EMPTY_MEMBER_LAST_NAME,
    EMPTY_OR_INVALID_MEMBER_JOB_POSITION,

    EMPTY_PROJECT_NAME,
    EMPTY_FEATURE_NAME,
    INVALID_FEATURE_REQUIREMENT

}