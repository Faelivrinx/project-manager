package pl.jurasz.dev.projectmanager.integration.team

import pl.jurasz.dev.projectmanager.integration.base.BaseIntegrationSpec
import pl.jurasz.dev.projectmanager.integration.team.base.OperationOnTeamEndpoint
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import static pl.jurasz.dev.projectmanager.integration.team.base.SampleMemberDto.sampleMemberDto
import static pl.jurasz.dev.projectmanager.integration.team.base.SampleNewTeamDto.sampleNewTeamDto

class TeamCreationSpec extends BaseIntegrationSpec implements OperationOnTeamEndpoint{

    def "Should not create team already existing"(){
        given:
        postNewTeam(sampleNewTeamDto())

        when:
        def result = postNewTeam(sampleNewTeamDto())

        then:
        result.statusCode == UNPROCESSABLE_ENTITY
        result.body.message == "TEAM_ALREADY_EXISTS"
    }

    @Unroll
    def "Should not create team with empty name"(){
        when:
        def response = postNewTeam(sampleNewTeamDto(name: name))

        then:
        response.statusCode == UNPROCESSABLE_ENTITY

        where:
        name << ['', ' ']
    }

    @Unroll
    def "Should not add member without first name"(){
        given:
        postNewTeam(sampleNewTeamDto())

        when:
        def result = addMemberToTeam(sampleMemberDto(firstName: firstName), sampleNewTeamDto())

        then:
        result.statusCode == UNPROCESSABLE_ENTITY
        result.body.message == 'EMPTY_MEMBER_FIRST_NAME'

        where:
        firstName << ['', ' ']
    }

    @Unroll
    def "Should not add member without last name"(){
        given:
        postNewTeam(sampleNewTeamDto())

        when:
        def result = addMemberToTeam(sampleMemberDto(lastName: lastName), sampleNewTeamDto())

        then:
        result.statusCode == UNPROCESSABLE_ENTITY
        result.body.message == 'EMPTY_MEMBER_LAST_NAME'

        where:
        lastName << ['', ' ']
    }

    @Unroll
    def "Should not add member with invalid job position"(){
        postNewTeam(sampleNewTeamDto())

        when:
        def result = addMemberToTeam(sampleMemberDto(jobPosition: jobPosition), sampleNewTeamDto())

        then:
        result.statusCode == UNPROCESSABLE_ENTITY
        result.body.message == errorCode

        where:
        jobPosition                 | errorCode
        ''                          |'EMPTY_OR_INVALID_MEMBER_JOB_POSITION'
        ' '                         |'EMPTY_OR_INVALID_MEMBER_JOB_POSITION'
        'InvalidJobPosition %$'     |'EMPTY_OR_INVALID_MEMBER_JOB_POSITION'
        'fdsfdffgeq3fgda s'         |'EMPTY_OR_INVALID_MEMBER_JOB_POSITION'
    }




}
