package pl.jurasz.dev.projectmanager.domain.team

data class Team ( val name: String,
                  val currentlyImplementedProjects: Int = 0,
                  val members: List<Employee> = emptyList()){
}