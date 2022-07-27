package com.techragesh.demoapp.model.response

import com.techragesh.demoapp.model.Employee

data class EmployeeResponse(
    var status: String?,
    var data: Array<Employee>?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EmployeeResponse

        if (status != other.status) return false
        if (data != null) {
            if (other.data == null) return false
            if (!data.contentEquals(other.data)) return false
        } else if (other.data != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = status?.hashCode() ?: 0
        result = 31 * result + (data?.contentHashCode() ?: 0)
        return result
    }
}
