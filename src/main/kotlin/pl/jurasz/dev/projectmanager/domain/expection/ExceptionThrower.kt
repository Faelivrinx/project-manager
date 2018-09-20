package pl.jurasz.dev.projectmanager.domain.expection

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
internal class EntityAlreadyExistException(msg: ErrorCode) : RuntimeException(msg.toString())

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
internal class InvalidEntityException(msg: ErrorCode) : RuntimeException(msg.toString())