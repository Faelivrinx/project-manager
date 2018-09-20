package pl.jurasz.dev.projectmanager.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import pl.jurasz.dev.projectmanager.application.team.dto.NewTeamDto
import pl.jurasz.dev.projectmanager.application.team.TeamService
import pl.jurasz.dev.projectmanager.application.team.dto.ExistingTeamDto
import pl.jurasz.dev.projectmanager.application.team.dto.TeamMemberDto

@RestController
@RequestMapping(value = ["/teams"])
internal class TeamEndpoint(
        val teamService: TeamService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createTeam(@RequestBody team: NewTeamDto){
        teamService.createTeam(team)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/{teamName}/members")
    fun createTeamMember(@PathVariable teamName: String, @RequestBody teamMember: TeamMemberDto){
        teamService.addTeamMember(teamName, teamMember)
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    fun getTeams() : List<ExistingTeamDto>{
        return teamService.getTeams()
    }


}