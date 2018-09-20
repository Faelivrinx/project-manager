package pl.jurasz.dev.projectmanager.infrastructure.team

import pl.jurasz.dev.projectmanager.domain.team.Employee
import pl.jurasz.dev.projectmanager.domain.team.JobPosition

data class DbEmployee (
        val firstName: String,
        val lastName: String,
        val jobPosition: String
){
    companion object {
        fun toDbEmployee(employee: Employee) : DbEmployee = DbEmployee(
                employee.firstName,
                employee.lastName,
                employee.jobPosition.toString())

        fun fromDbEmployee(dbEmployee: DbEmployee) : Employee = Employee(
                dbEmployee.firstName,
                dbEmployee.lastName,
                JobPosition.valueOf(dbEmployee.jobPosition))

    }

}
