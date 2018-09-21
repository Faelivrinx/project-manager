package pl.jurasz.dev.projectmanager.integration.project.base

import pl.jurasz.dev.projectmanager.application.project.NewProjectDraft

class SampleProjectDto {
    static final Map NEW_PROJECT_DRAFT = ["name": "project1"]

    static final sampleNewProjectDraft(Map<String, Object> properties = [:]){
        properties = properties + NEW_PROJECT_DRAFT
        return new NewProjectDraft(properties.name)
    }


}
