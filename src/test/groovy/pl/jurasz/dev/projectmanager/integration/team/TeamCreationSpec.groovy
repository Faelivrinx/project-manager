package pl.jurasz.dev.projectmanager.integration.team

import org.springframework.http.HttpStatus
import pl.jurasz.dev.projectmanager.domain.Team
import pl.jurasz.dev.projectmanager.integration.base.BaseIntegrationSpec

class TeamCreationSpec extends BaseIntegrationSpec{

    def "Create new team"(){
        given:
        def team = new Team("Programisci JVM")

        when:
        def response = post("/team", team)

        then:
        response.statusCode == HttpStatus.CREATED
    }

}
