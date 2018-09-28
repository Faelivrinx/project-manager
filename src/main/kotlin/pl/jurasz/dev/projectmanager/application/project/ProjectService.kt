package pl.jurasz.dev.projectmanager.application.project

import org.springframework.stereotype.Service
import pl.jurasz.dev.projectmanager.application.project.dto.NewProjectDraftDto
import pl.jurasz.dev.projectmanager.application.project.dto.NewProjectDto
import pl.jurasz.dev.projectmanager.domain.project.Project
import pl.jurasz.dev.projectmanager.domain.project.ProjectFactory
import pl.jurasz.dev.projectmanager.domain.project.ProjectRepository

@Service
class ProjectService(
        val projectRepository: ProjectRepository,
        val projectFactory: ProjectFactory
) {

    fun createDraftProject(draftProject: NewProjectDraftDto){
        val project = projectFactory.createDraftProject(draftProject.name)
        projectRepository.save(project)
    }

    fun createFullProject(project: NewProjectDto) {
        val fullProject = projectFactory.createFullProject(project.name, project.features)
        projectRepository.save(fullProject)
    }
}