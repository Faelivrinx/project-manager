package pl.jurasz.dev.projectmanager.integration.team.base

import pl.jurasz.dev.projectmanager.application.team.dto.NewTeamDto

class SampleNewTeamDto {
    static final Map NEW_TEAM_DTO = ["name":"team1"]

    static final sampleNewTeamDto(Map<String, Object> properties = [:]){
        properties  = NEW_TEAM_DTO + properties
        return new NewTeamDto(properties.name)
    }
}
