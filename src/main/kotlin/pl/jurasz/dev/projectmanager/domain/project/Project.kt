package pl.jurasz.dev.projectmanager.domain.project

import org.apache.commons.lang3.StringUtils.isBlank
import org.springframework.data.annotation.Id
import pl.jurasz.dev.projectmanager.domain.expection.ErrorCode
import pl.jurasz.dev.projectmanager.domain.expection.InvalidEntityException
import pl.jurasz.dev.projectmanager.domain.values.Feature
import pl.jurasz.dev.projectmanager.domain.values.Status

data class Project(
        @Id val id: String,
        val name: String,
        val status: Status = Status.TO_DO,
        val assignedTeam: String? = null,
        var features: List<Feature>? = null
) {
    init {
        validateName()
        features = normalize(features)
        validateFeatures(features)
    }


    private fun normalize(features: List<Feature>?): List<Feature> {
        return when {
            features?.isEmpty() == true -> emptyList()
            else -> features!!
        }
    }

    private fun validateName() {
        if (isBlank(name)){
            throw InvalidEntityException(ErrorCode.EMPTY_PROJECT_NAME)
        }

    }

    private fun validateFeatures(features: List<Feature>?) {
        features?.forEach { validFeature(it) }
    }

    private fun validFeature(feature: Feature) {
        if (feature.hasInvalidRequirement()){
            throw InvalidEntityException(ErrorCode.INVALID_FEATURE_REQUIREMENT)
        }
    }

}