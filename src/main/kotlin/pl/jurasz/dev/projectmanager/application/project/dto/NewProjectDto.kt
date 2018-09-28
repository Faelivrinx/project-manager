package pl.jurasz.dev.projectmanager.application.project.dto

data class NewProjectDto (
        val name: String,
        val features: List<NewFeatureDto>
){

}
