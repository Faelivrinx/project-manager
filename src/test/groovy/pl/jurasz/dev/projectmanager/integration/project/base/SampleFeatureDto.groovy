package pl.jurasz.dev.projectmanager.integration.project.base

import pl.jurasz.dev.projectmanager.application.project.dto.NewFeatureDto

class SampleFeatureDto {
    static final Map SAMPLE_FEATURE_DTO = ["name": "feature1", "requirement": "OPTIONAL"]

    static final sampleFeatureDto(Map<String, Object> properties = [:]){
        properties = SAMPLE_FEATURE_DTO + properties
        return new NewFeatureDto(properties.name, properties.requirement)
    }
}
