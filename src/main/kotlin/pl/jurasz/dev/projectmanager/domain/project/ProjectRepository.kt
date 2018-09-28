package pl.jurasz.dev.projectmanager.domain.project

interface ProjectRepository {

    fun save(project: Project)

}