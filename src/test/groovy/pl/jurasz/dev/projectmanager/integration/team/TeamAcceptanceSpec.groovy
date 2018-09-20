package pl.jurasz.dev.projectmanager.integration.team

import org.springframework.http.HttpStatus
import pl.jurasz.dev.projectmanager.integration.base.BaseIntegrationSpec
import pl.jurasz.dev.projectmanager.integration.team.base.OperationOnTeamEndpoint
import pl.jurasz.dev.projectmanager.integration.team.base.SampleNewTeamDto

import static org.springframework.http.HttpStatus.CREATED
import static pl.jurasz.dev.projectmanager.integration.team.base.SampleNewTeamDto.sampleNewTeamDto

class TeamAcceptanceSpec extends BaseIntegrationSpec implements OperationOnTeamEndpoint {

    def "Should create new team"(){
        when:
        def response = postNewTeam(sampleNewTeamDto())

        then:
        response.statusCode == CREATED

        when:
        response = getTeams()

        then:
        response.body.size() == 1
        response.body[0].name == sampleNewTeamDto().name
        response.body[0].currentlyImplementedProjects == 0
        response.body[0].busy == false
        response.body[0].members == []

    }
}
