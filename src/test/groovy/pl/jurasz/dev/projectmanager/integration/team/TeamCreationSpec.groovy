package pl.jurasz.dev.projectmanager.integration.team

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpStatus
import pl.jurasz.dev.projectmanager.application.team.dto.ExistingTeamDto
import pl.jurasz.dev.projectmanager.application.team.dto.NewTeamDto
import pl.jurasz.dev.projectmanager.integration.base.BaseIntegrationSpec
import pl.jurasz.dev.projectmanager.integration.team.base.OperationOnTeamEndpoint
import pl.jurasz.dev.projectmanager.integration.team.base.SampleNewTeamDto

class TeamCreationSpec extends BaseIntegrationSpec implements OperationOnTeamEndpoint{

    def "Create new team"(){
        when: "new team is created"
        def response = postNewTeam(SampleNewTeamDto.sampleNewTeamDto())

        then: "system create new team"
        response.statusCode == HttpStatus.CREATED

        when: "get all created teams"
        response = getTeams()

        then: "verify that one team was created"
        response.statusCode == HttpStatus.OK
        response.body.size() == 1

        and: "has default values"
        with(response.body[0]){
            name == SampleNewTeamDto.sampleNewTeamDto().name
            currentlyImplementedProjects == 0
            true
            members == []
        }

    }

}
