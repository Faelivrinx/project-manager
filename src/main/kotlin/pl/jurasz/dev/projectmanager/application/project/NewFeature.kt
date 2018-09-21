package pl.jurasz.dev.projectmanager.application.project

import pl.jurasz.dev.projectmanager.domain.values.Requirement

data class NewFeature (
        val name: String,
        val requirement: Requirement
){

}
