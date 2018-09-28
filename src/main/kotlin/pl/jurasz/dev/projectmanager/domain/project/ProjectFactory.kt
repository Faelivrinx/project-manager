package pl.jurasz.dev.projectmanager.domain.project

import org.springframework.stereotype.Component
import pl.jurasz.dev.projectmanager.application.project.dto.NewFeatureDto
import pl.jurasz.dev.projectmanager.domain.UniqueIdentifierGenerator
import pl.jurasz.dev.projectmanager.domain.values.Feature

@Component
class ProjectFactory(
        val generator: UniqueIdentifierGenerator
) {

    fun createDraftProject(name: String) : Project{
        val project = Project(generator.generateUniqueIdentifier(), name)
        return project
    }

    fun createFullProject(name: String, features: List<NewFeatureDto>): Project{
        return Project(
                id = generator.generateUniqueIdentifier(),
                name = name,
                features = Feature.toFeatures(features)
        )
    }
}