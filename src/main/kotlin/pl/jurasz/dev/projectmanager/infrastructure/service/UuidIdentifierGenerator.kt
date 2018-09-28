package pl.jurasz.dev.projectmanager.infrastructure.service

import org.springframework.stereotype.Service
import pl.jurasz.dev.projectmanager.domain.UniqueIdentifierGenerator
import java.util.*

@Service
class UuidIdentifierGenerator : UniqueIdentifierGenerator {

    override fun generateUniqueIdentifier(): String {
        return  UUID.randomUUID().toString()
    }
}