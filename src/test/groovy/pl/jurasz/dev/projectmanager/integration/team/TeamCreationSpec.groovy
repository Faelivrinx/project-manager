package pl.jurasz.dev.projectmanager.integration.team

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpStatus
import pl.jurasz.dev.projectmanager.application.team.dto.NewTeamDto
import pl.jurasz.dev.projectmanager.integration.base.BaseIntegrationSpec

class TeamCreationSpec extends BaseIntegrationSpec{

    def "Create new team"(){
        given:
        def teamName = "Team 1"

        when:
        def response = post("/team", new NewTeamDto(teamName))

        then:
        response.statusCode == HttpStatus.CREATED

        when:
        response = get("/teams", new ParameterizedTypeReference<List<ExistingTeam>>(){})

        then:
        response.statusCode == HttpStatus.OK
        response.body != null
        response.body.size() == 1
        with(response.body[0]){
            name == "Team 1"
        }

    }

}
