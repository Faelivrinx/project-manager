package pl.jurasz.dev.projectmanager.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.jurasz.dev.projectmanager.application.team.dto.NewTeamDto
import pl.jurasz.dev.projectmanager.application.team.TeamService
import pl.jurasz.dev.projectmanager.application.team.dto.ExistingTeamDto

@RestController
@RequestMapping(value = ["/teams"])
internal class TeamEndpoint(
        val teamService: TeamService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTeam(@RequestBody team: NewTeamDto){
        teamService.createTeam(team)
    }

    @PostMapping(value = "/{teamName}/members")
    @ResponseStatus(HttpStatus.CREATED)
    fun createTeamMember(@PathVariable teamName: String){
        
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getTeams() : List<ExistingTeamDto>{
        return teamService.getTeams()
    }


}