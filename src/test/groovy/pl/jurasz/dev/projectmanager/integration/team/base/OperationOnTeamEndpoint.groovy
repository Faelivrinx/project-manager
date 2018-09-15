package pl.jurasz.dev.projectmanager.integration.team.base

import org.springframework.http.ResponseEntity
import pl.jurasz.dev.projectmanager.integration.base.BaseHttpMethods

trait OperationOnTeamEndpoint implements BaseHttpMethods{


    ResponseEntity postNewTeam(Object requestBody){
        return post("/teams", requestBody)
    }

    ResponseEntity getTeams(){
        return get("/teams", List)
    }
}