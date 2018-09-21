package pl.jurasz.dev.projectmanager.integration.project

import pl.jurasz.dev.projectmanager.integration.base.BaseIntegrationSpec
import pl.jurasz.dev.projectmanager.integration.project.base.OperationOnProjectEndpoint
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.jurasz.dev.projectmanager.integration.project.base.SampleProjectDto.sampleNewProjectDraft

class ProjectCreationSpec extends BaseIntegrationSpec implements OperationOnProjectEndpoint {

    def "Should create empty project"(){

        when: "create new project draft"
        def response = createNewDraftProject(sampleNewProjectDraft())

        then: "server status should return 201"
        response.statusCode == CREATED

    }

    @Unroll
    def "Should not create project with empty name"(){

        when: "create new project draft with empty name"
        def response = createNewDraftProject(sampleNewProjectDraft(name: name))

        then:
        response.statusCode == UNPROCESSABLE_ENTITY

        where:
        name << ['', ' ']
    }

}
