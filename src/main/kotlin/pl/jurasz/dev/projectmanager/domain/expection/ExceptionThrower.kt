package pl.jurasz.dev.projectmanager.domain.expection

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Team already exists")
internal class ExceptionThrower : RuntimeException()

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Team doesn't exists")
internal class NonExistenceTeamExcepiton : RuntimeException()

