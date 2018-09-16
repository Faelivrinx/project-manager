package pl.jurasz.dev.projectmanager.integration.team.base

import org.springframework.http.ResponseEntity
import pl.jurasz.dev.projectmanager.application.team.dto.NewTeamDto
import pl.jurasz.dev.projectmanager.integration.base.BaseHttpMethods

trait OperationOnTeamEndpoint implements BaseHttpMethods{


    ResponseEntity postNewTeam(Object requestBody){
        return post("/teams", requestBody)
    }

    ResponseEntity getTeams(){
        return get("/teams", List)
    }

    ResponseEntity addMemberToTeam(Object requestBody, NewTeamDto newTeamDto){
        def teamName = newTeamDto.name
        return post("/teams/$teamName/members", requestBody)
    }
}