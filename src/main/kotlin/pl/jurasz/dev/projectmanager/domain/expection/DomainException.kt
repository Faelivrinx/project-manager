package pl.jurasz.dev.projectmanager.domain.expection

abstract class DomainException(
        val msg: String,
        val errorCode: ErrorCode
)

enum class ErrorCode{
    UNEXPECTED_ERROR,
    TEAM_ALREADY_EXISTS,
    NON_EXISTING_TEAM,
    INVALID_MEMBER_JOB_POSITION,
    EMPTY_TEAM_NAME
}