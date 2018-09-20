package pl.jurasz.dev.projectmanager.integration.team.base

import pl.jurasz.dev.projectmanager.application.team.dto.TeamMemberDto

class SampleMemberDto {
    static final Map TEAM_MEMBER_DTO = [
            "firstName": "Jan",
            "lastName": "Kowalski",
            "jobPosition": "DEVELOPER"
    ]

    static final sampleMemberDto(Map<String, Object> properties= [:]){
        properties = TEAM_MEMBER_DTO + properties
        return new TeamMemberDto(
                properties.firstName,
                properties.lastName,
                properties.jobPosition
        )
    }
}
