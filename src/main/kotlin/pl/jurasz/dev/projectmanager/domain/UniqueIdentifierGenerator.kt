package pl.jurasz.dev.projectmanager.domain

interface UniqueIdentifierGenerator {
    fun generateUniqueIdentifier(): String
}