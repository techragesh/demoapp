package com.techragesh.demoapp.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Employee (
    @JsonProperty("id")
    var id: Int,
    @JsonProperty("employee_name")
    var employeeName: String?,
    @JsonProperty("employee_salary")
    var employeeSalary: Number?,
    @JsonProperty("employee_age")
    var employeeAge: Number?,
    @JsonProperty("profile_image")
    var profileImage: String?
)
