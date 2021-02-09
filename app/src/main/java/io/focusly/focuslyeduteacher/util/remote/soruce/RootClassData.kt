package io.focusly.focuslyedu.data.remote.source

import androidx.annotation.Keep

//2021/02/03
@Keep
data class RootClassData(
    //Field
    var ownerUid: String? = "",
    var ownerName: String? = "",
    var departmentKey: String? = "",
    var classKey: String? = "",
    var className: String? = "",
    var articleCount:String? ="",


    //Directory
    var CLASSROOM: HashMap<String, ClassroomData>? = HashMap(),
    var CLASSMATE: HashMap<String, UserData>? = HashMap(),
    var ANALYSIS: HashMap<String, ClassroomData>? = HashMap(),
    var MANAGER: HashMap<String, UserData>? = HashMap()
) {
    fun getRootClass(): Map<String, String?> {
        return mapOf(
            "ownerUid" to ownerUid,
            "ownerName" to ownerName,
            "departmentKey" to departmentKey,
            "classKey" to classKey,
            "className" to className,
            "articleCount" to articleCount
        )
    }
}
