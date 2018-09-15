package pl.jurasz.dev.projectmanager.domain.team

data class Employee(
        val firstName: String,
        val lastName: String,
        val jobPosition: JobPosition
)

enum class JobPosition{
    DEVELOPER,
    SCRUM_MASTER,
    PRODUCT_OWNER,
    INVALID;
}