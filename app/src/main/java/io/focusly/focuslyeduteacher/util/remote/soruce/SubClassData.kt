package io.focusly.focuslyedu.data.remote.source

data class SubClassData (
    //Field
    var ownerUid: String? = "",
    var ownerName:String?="",
    var classKey: String? = "",
    var className: String? = "",

    //for user/department/class
    var classRoomKey:String?="",
    var absenceCount:String?="0",    //이탈한 횟수
    var attendCount:String?="0",     //출석한 횟수
    var attendTime:String?="0",      //출석시간
    var correctQuizCount:String?="0",   //맞춘 퀴즈 수
    var currentReadingTime:String?="0",  //현재 내가 읽은 시간
    var readLength:String?="0",          //읽은 글자수
    var readQuizCount:String?="0",       //오픈된 퀴즈 수

    //for notification
    var userUid:String?="",
    var date:String?="",

    //Directory
    var CLASSROOM: HashMap<String, ClassroomData>? = HashMap(),
    var CLASSMATE: HashMap<String, UserData>? = HashMap(),
    var ANALYSIS: HashMap<String, ClassroomData>? = HashMap(),
    var ARTICLE: HashMap<String, String>? = HashMap(),
    var MANAGER: HashMap<String, UserData>? = HashMap()
){
    fun getUserDepartmentClass():Map<String, String?> {
        return mapOf(
            "classKey" to classKey,
            "className" to className,
            "classRoomKey" to classRoomKey,
            "ownerUid" to ownerUid,
            "absenceCount" to absenceCount.toString(),
            "attendCount" to attendCount.toString(),
            "attendTime" to attendTime.toString(),
            "correctQuizCount" to correctQuizCount.toString(),
            "currentReadingTime" to currentReadingTime.toString(),
            "readLength" to readLength.toString(),
            "readQuizCount" to readQuizCount.toString()
        )
    }
    //Department/Member/Class, //Department/Manager/Class, //DepartmentClass
    fun getDepartmentClass():Map<String, String?> {
        return mapOf(
            "classKey" to classKey,
            "className" to className,
            "ownerUid" to ownerUid,
            "ownerName" to ownerName
        )
    }

    fun getNotificationClass():Map<String, String?> {
        return mapOf(
            "classKey" to classKey,
            "classRoomKey" to classRoomKey,
            "userUid" to userUid,
            "date" to date
        )
    }
}