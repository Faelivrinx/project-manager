package pl.jurasz.dev.projectmanager.integration.project.base

import org.springframework.http.ResponseEntity
import pl.jurasz.dev.projectmanager.integration.base.BaseHttpMethods

trait OperationOnProjectEndpoint implements BaseHttpMethods{

    ResponseEntity createNewDraftProject(Object requestBody){
        return post("/projects/drafts", requestBody)
    }


    ResponseEntity createNewProject(Object requestBody){
        return post("/projects", requestBody)
    }

}