package pl.jurasz.dev.projectmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import pl.jurasz.dev.projectmanager.domain.TeamRepository
import pl.jurasz.dev.projectmanager.infrastructure.team.TeamRepositoryImpl

@SpringBootApplication
class Application

    fun main(args: Array<String>) {
        runApplication<Application>(*args)
    }


