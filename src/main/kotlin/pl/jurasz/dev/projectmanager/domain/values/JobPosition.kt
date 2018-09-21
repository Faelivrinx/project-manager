package pl.jurasz.dev.projectmanager.domain.values

enum class JobPosition{
    DEVELOPER,
    SCRUM_MASTER,
    PRODUCT_OWNER,
    INVALID;

    fun isInvalid() : Boolean = this == INVALID
}