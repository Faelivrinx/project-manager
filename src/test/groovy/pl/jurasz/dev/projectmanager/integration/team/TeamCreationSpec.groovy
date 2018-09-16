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

    def "Create new team and add member"(){
        when: "new team is created"
        def response = postNewTeam(sampleNewTeamDto())

        then: "system create new team"
        response.statusCode == HttpStatus.CREATED

        when: "get all created teams"
        response = getTeams()

        then: "verify that one team was created"
        response.statusCode == HttpStatus.OK
        response.body.size() == 1

        and: "has default values"
        with(response.body[0]){
            name == sampleNewTeamDto().name
            currentlyImplementedProjects == 0
            true
            members == []
        }

        when: "add member to team"

    }

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
