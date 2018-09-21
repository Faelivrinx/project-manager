package pl.jurasz.dev.projectmanager.application.project

data class NewProject (
        val name: String,
        val features: List<NewFeature>
){

}
