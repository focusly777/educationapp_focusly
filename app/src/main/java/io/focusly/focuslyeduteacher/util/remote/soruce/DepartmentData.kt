package io.focusly.focuslyedu.data.remote.source

import androidx.annotation.Keep

//2021/02/03
@Keep
data class DepartmentData(
    //Field
    var departmentKey:String? = "",
    var departmentName:String? = "",
    var departmentNumber:String? = "",
    var location:String? = "",
    var administrator:String? = "",

    //for user/department
    var group:String?="",
    var personalId:String?="",

    //Directory
    var CLASS:HashMap<String, SubClassData>?= HashMap(),
    var MEMBER:HashMap<String, UserData>?= HashMap(),
    var MANAGER:HashMap<String, UserData>?= HashMap()
) {
    //Root User
    fun getRootDepartment(): Map<String, String?> {
        return mapOf(
            "departmentKey" to departmentKey,
            "departmentName" to departmentName,
            "departmentNumber" to departmentNumber,
            "location" to location,
            "administrator" to administrator
        )
    }

    fun getUserDepartment():Map<String, String?> {
        return mapOf(
            "departmentKey" to departmentKey,
            "departmentName" to departmentName,
            "departmentNumber" to departmentNumber,
            "location" to location,
            "administrator" to administrator,
            "group" to group,
            "personalId" to personalId
        )
    }
}
