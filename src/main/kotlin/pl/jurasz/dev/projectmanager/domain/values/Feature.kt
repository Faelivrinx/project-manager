package pl.jurasz.dev.projectmanager.domain.values

import org.apache.commons.lang3.StringUtils.isBlank
import pl.jurasz.dev.projectmanager.application.project.dto.NewFeatureDto
import pl.jurasz.dev.projectmanager.domain.expection.ErrorCode
import pl.jurasz.dev.projectmanager.domain.expection.InvalidEntityException

data class Feature (
        val name: String,
        val status: Status = Status.TO_DO,
        val requirement: Requirement
){

    init {
        validateName(name)
    }

    private fun validateName(name: String) {
        if (isBlank(name)){
            throw InvalidEntityException(ErrorCode.EMPTY_FEATURE_NAME)
        }
    }


    fun hasInvalidRequirement(): Boolean = requirement.isInvalid()
    fun hasNoStatus(): Boolean = isBlank(status.toString())
    fun hasNoRequirement(): Boolean = isBlank(requirement.toString())

    companion object {
        fun toFeatures(newfeaturesDto: List<NewFeatureDto>) : List<Feature> = newfeaturesDto.map { toFeature(it) }


        fun toFeature(newFeatureDto: NewFeatureDto) : Feature = Feature(
                name = newFeatureDto.name,
                requirement = checkRequirement(newFeatureDto.requirement)
        )

        fun checkRequirement(requirement: String): Requirement{
            return try {
                Requirement.valueOf(requirement)
            } catch (e: IllegalArgumentException){
                Requirement.INVALID
            }
        }
    }
}