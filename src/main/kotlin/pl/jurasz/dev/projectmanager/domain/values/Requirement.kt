package pl.jurasz.dev.projectmanager.domain.values

enum class Requirement {
    OPTIONAL, NECESSARY, INVALID;

    fun isInvalid(): Boolean {
        if (this == INVALID){
            return true
        }
        return false
    }
}
