package pl.jurasz.dev.projectmanager.integration.project.base

import pl.jurasz.dev.projectmanager.application.project.dto.NewProjectDto

import static pl.jurasz.dev.projectmanager.integration.project.base.SampleFeatureDto.sampleFeatureDto

class SampleFullProjectDto {
    static final Map SAMPLE_FULL_PROJECT_DTO= ["name": "project1", "features": [sampleFeatureDto()]]

    static final sampleFullProjectDto(Map<String, Object> properties = [:]){
        properties = SAMPLE_FULL_PROJECT_DTO + properties
        return new NewProjectDto(properties.name, properties.features)

    }
}
