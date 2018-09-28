package pl.jurasz.dev.projectmanager.integration.project

import pl.jurasz.dev.projectmanager.integration.base.BaseIntegrationSpec
import pl.jurasz.dev.projectmanager.integration.project.base.OperationOnProjectEndpoint
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.jurasz.dev.projectmanager.integration.project.base.SampleDraftProjectDto.sampleNewProjectDraft

class DraftProjectCreationSpec extends BaseIntegrationSpec implements OperationOnProjectEndpoint {

    @Unroll
    def "Should not create project with empty name"(){

        when: "create new project draft with empty name"
        def response = createNewDraftProject(sampleNewProjectDraft(name: name))

        then:
        response.statusCode == UNPROCESSABLE_ENTITY
        response.body.message == "EMPTY_PROJECT_NAME"

        where:
        name << ['', ' ']
    }

}
