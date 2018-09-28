package pl.jurasz.dev.projectmanager.application.project.dto

import pl.jurasz.dev.projectmanager.domain.values.Requirement

data class NewFeatureDto (
        val name: String,
        val requirement: String
){

}
