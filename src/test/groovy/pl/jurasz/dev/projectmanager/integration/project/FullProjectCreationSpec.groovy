package pl.jurasz.dev.projectmanager.integration.project

import org.springframework.http.HttpStatus
import pl.jurasz.dev.projectmanager.integration.base.BaseIntegrationSpec
import pl.jurasz.dev.projectmanager.integration.project.base.OperationOnProjectEndpoint
import pl.jurasz.dev.projectmanager.integration.project.base.SampleFeatureDto
import spock.lang.Unroll

import static pl.jurasz.dev.projectmanager.integration.project.base.SampleFullProjectDto.sampleFullProjectDto

class FullProjectCreationSpec extends BaseIntegrationSpec implements OperationOnProjectEndpoint {

    @Unroll
    def "Should not create an unnamed new full-project"(){
        when:
        def response = createNewProject(sampleFullProjectDto(name: name))

        then:
        response.statusCode == HttpStatus.UNPROCESSABLE_ENTITY
        response.body.message == "EMPTY_PROJECT_NAME"

        where:
        name << ['', ' ']
    }

    @Unroll
    def "Should not create full project with an unnamed feature"(){
        given:
        def feature = SampleFeatureDto.sampleFeatureDto(name: featureName)
        def project = sampleFullProjectDto(features: [feature])

        when:
        def response = createNewProject(project)

        then:
        response.statusCode == HttpStatus.UNPROCESSABLE_ENTITY
        response.body.message == "EMPTY_FEATURE_NAME"

        where:
        featureName << ['', ' ']
    }
}
