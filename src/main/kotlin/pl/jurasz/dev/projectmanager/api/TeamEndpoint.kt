package pl.jurasz.dev.projectmanager.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.jurasz.dev.projectmanager.application.NewTeam
import pl.jurasz.dev.projectmanager.application.TeamService

@RestController
@RequestMapping(value = ["/team"])
internal class TeamEndpoint(
        val teamService: TeamService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTeam(@RequestBody team: NewTeam){
        teamService.createTeam(team)
    }
}