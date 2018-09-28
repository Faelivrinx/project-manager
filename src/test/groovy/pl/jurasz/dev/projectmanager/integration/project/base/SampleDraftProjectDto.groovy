package pl.jurasz.dev.projectmanager.integration.project.base

import pl.jurasz.dev.projectmanager.application.project.dto.NewProjectDraftDto

class SampleDraftProjectDto {
    static final Map NEW_PROJECT_DRAFT = ["name": "project1"]

    static final sampleNewProjectDraft(Map<String, Object> properties = [:]){
        properties = NEW_PROJECT_DRAFT + properties
        return new NewProjectDraftDto(properties.name)
    }


}
