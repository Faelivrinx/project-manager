package pl.jurasz.dev.projectmanager.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.jurasz.dev.projectmanager.application.project.NewProject
import pl.jurasz.dev.projectmanager.application.project.NewProjectDraft

@RestController
@RequestMapping(value = ["/projects"])
class ProjectEndpoint {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = ["/drafts"])
    fun createDraftProject(@RequestBody project: NewProjectDraft){

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createProject(@RequestBody project: NewProject){

    }
}