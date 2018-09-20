package pl.jurasz.dev.projectmanager.integration.team

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpStatus
import pl.jurasz.dev.projectmanager.application.team.dto.ExistingTeamDto
import pl.jurasz.dev.projectmanager.application.team.dto.NewTeamDto
import pl.jurasz.dev.projectmanager.integration.base.BaseIntegrationSpec
import pl.jurasz.dev.projectmanager.integration.team.base.OperationOnTeamEndpoint
import pl.jurasz.dev.projectmanager.integration.team.base.SampleNewTeamDto

import static pl.jurasz.dev.projectmanager.integration.team.base.SampleNewTeamDto.sampleNewTeamDto

class TeamCreationSpec extends BaseIntegrationSpec implements OperationOnTeamEndpoint{

    def "Should not create team with empty name"(){
        when:
        def response = postNewTeam(sampleNewTeamDto(name: name))

        then:
        response.statusCode == HttpStatus.UNPROCESSABLE_ENTITY

        where:
        name << ['', ' ']
    }

    def "Should not create team already existing"(){
        given:
        postNewTeam(sampleNewTeamDto())

        when:
        def result = postNewTeam(sampleNewTeamDto())

        then:
        result.statusCode == HttpStatus.UNPROCESSABLE_ENTITY
        result.body.message == "TEAM_ALREADY_EXISTS"

    }


}
