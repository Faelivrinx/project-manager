package pl.jurasz.dev.projectmanager.integration.team

import pl.jurasz.dev.projectmanager.integration.base.BaseIntegrationSpec
import pl.jurasz.dev.projectmanager.integration.team.base.OperationOnTeamEndpoint
import pl.jurasz.dev.projectmanager.integration.team.base.SampleMemberDto
import pl.jurasz.dev.projectmanager.integration.team.base.SampleNewTeamDto

import static org.springframework.http.HttpStatus.CREATED

class TeamAcceptanceSpec extends BaseIntegrationSpec implements OperationOnTeamEndpoint {

    def "Should create new team and add member"(){
        when: "new team is created"
        def response = postNewTeam(SampleNewTeamDto.sampleNewTeamDto())

        then: "system response - team is created"
        response.statusCode == CREATED

        when: "user asks for all created teams"
        response = getTeams()

        then: "check that one was created with default settings"
        response.body.size() == 1
        response.body[0].name == SampleNewTeamDto.sampleNewTeamDto().name
        response.body[0].currentlyImplementedProjects == 0
        response.body[0].busy == false
        response.body[0].members == []

        when: "member is added to team"
        response = addMemberToTeam(SampleMemberDto.sampleMemberDto(),SampleNewTeamDto.sampleNewTeamDto())

        then: "system response - member is added"
        response.statusCode == CREATED

        when: "user ask again for all created teams"
        response = getTeams()

        then: "check that member was added"
        response.body[0].members.size() == 1
        response.body[0].members[0].firstName == SampleMemberDto.sampleMemberDto().firstName
        response.body[0].members[0].lastName== SampleMemberDto.sampleMemberDto().lastName
        response.body[0].members[0].jobPosition == SampleMemberDto.sampleMemberDto().jobPosition

    }
}
