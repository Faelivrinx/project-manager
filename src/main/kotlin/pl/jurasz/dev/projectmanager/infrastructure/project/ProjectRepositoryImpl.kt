package pl.jurasz.dev.projectmanager.infrastructure.project

import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Component
import pl.jurasz.dev.projectmanager.domain.project.Project
import pl.jurasz.dev.projectmanager.domain.project.ProjectRepository

@Component
class ProjectRepositoryImpl(
        val mongoTemplate: MongoTemplate
) : ProjectRepository {

    override fun save(project: Project) {
        mongoTemplate.save(project)
    }

}