package pl.jurasz.dev.projectmanager.integration.team.base

import pl.jurasz.dev.projectmanager.application.team.dto.TeamMemberDto
import pl.jurasz.dev.projectmanager.domain.team.JobPosition

class SampleTeamMemberDto {
    static final Map TEAM_MEMBER_DTO = [
            "firstName": "Jan",
            "lastName": "Kowalski",
            "jobPosition": JobPosition.DEVELOPER
    ]

    static final sampleTeamMemberDto(Map<String, Object> properties = [:]){
            properties = TEAM_MEMBER_DTO + properties
            return TeamMemberDto(
                    properties.firstName,
                    properties.lastName,
                    properties.jobPositon.toString())
    }

}
