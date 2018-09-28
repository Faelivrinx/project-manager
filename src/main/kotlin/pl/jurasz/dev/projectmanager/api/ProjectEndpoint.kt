package pl.jurasz.dev.projectmanager.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.jurasz.dev.projectmanager.application.project.ProjectService
import pl.jurasz.dev.projectmanager.application.project.dto.NewProjectDto
import pl.jurasz.dev.projectmanager.application.project.dto.NewProjectDraftDto

@RestController
@RequestMapping(value = ["/projects"])
class ProjectEndpoint (
        val projectService: ProjectService
){

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = ["/drafts"])
    fun createDraftProject(@RequestBody project: NewProjectDraftDto){
        projectService.createDraftProject(project)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createProject(@RequestBody project: NewProjectDto){
        projectService.createFullProject(project)
    }
}