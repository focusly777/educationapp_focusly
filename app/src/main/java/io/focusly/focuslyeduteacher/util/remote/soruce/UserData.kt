package io.focusly.focuslyedu.data.remote.source

import androidx.annotation.Keep

//2021/02/03
@Keep
data class UserData(
    //Field
    var userEmail: String? = "",
    var userUid: String? = "",
    var userName: String? = "",
    var userPhoneNumber: String? = "",
    var userType: String? = "",
    var userDeleteDate: String? = "",

    var profileUid: String? = "",
    var providerId: String? = "",

    var absenceCount: String? = "0",    //이탈한 횟수
    var attendCount: String? = "0",     //출석한 횟수
    var attendTime: String? = "0",      //출석시간
    var readQuizCount: String? = "0",       //오픈된 퀴즈 수
    var correctQuizCount: String? = "0",
    var totalQuizCount: String? = "0",
    var currentReadingTime: String? = "0",
    var readLength: String? ="0",
    var totalSearchCount: String? = "0",


    //for class/classmate
    var classRoomKey: String? = "",
    var personalId: String? = "",

    //for department/member
    var groupName: String? = "",


    //Directory
    var FOLDER: HashMap<String, FolderData>? = HashMap(),
    var DEPARTMENT: HashMap<String, DepartmentData>? = HashMap(),
    var ARTICLE: HashMap<String, ArticleData>? = HashMap(),
    var SHARED_ARTICLE: HashMap<String, ArticleData>? = HashMap(),
    var DELETED_ARTICLE: HashMap<String, ArticleData>? = HashMap(),

    //for notification/class/analysis
    var articleKey: String? = "",//optional
    var classKey: String? = "",
    var date:String?="",

    //for Notification, Department/Member/class
    var CLASS: HashMap<String, SubClassData>? = HashMap()
) {
    //Root User
    fun getRootUser(): Map<String, String?> {
        return mapOf(
            "userEmail" to userEmail,
            "userUid" to userUid,
            "userName" to userName,
            "userPhoneNumber" to userPhoneNumber,
            "userType" to userType,
            "userDeleteDate" to userDeleteDate,
            "profileUid" to profileUid,
            "providerId" to providerId,
            "correctQuizCount" to correctQuizCount,
            "totalQuizCount" to totalQuizCount,
            "readQuizCount" to readQuizCount,
            "currentReadingTime" to currentReadingTime,
            "readLength" to readLength,
            "totalSearchCount" to totalSearchCount
        )
    }
    //user/department/class/manager, //CLASS/MANAGER, //DEPARTMENT/MANAGER
    fun getManager(): Map<String, String?> {
        return mapOf(
            "userName" to userName,
            "userUid" to userUid,
            "personalId" to personalId
        )
    }

    //CLASS/CLASSMATE
    fun getClassClassmate(): Map<String, String?> {
        return mapOf(
            "userName" to userName,
            "userUid" to userUid,
            "classRoomKey" to classRoomKey,
            "personalId" to personalId
        )
    }
    //CLASS/ANALYSIS/ARTICLE/CLASSMATE
    fun getClassAnalysisArticleClassmate():Map<String, String?>{
        return mapOf(
            "userName" to userName,
            "userUid" to userUid,
            "absenceCount" to absenceCount,
            "attendCount" to attendCount,
            "attendTime" to attendTime,
            "correctQuizCount" to correctQuizCount,
            "currentReadingTime" to currentReadingTime,
            "readLength" to readLength,
            "readQuizCount" to readQuizCount
        )
    }
    //DEPARTMENT/MEMBER
    fun getDepartmentMember():Map<String, String?>{
        return mapOf(
            "userName" to userName,
            "userUid" to userUid,
            "groupName" to groupName,
            "personalId" to personalId
        )
    }

    fun getNotificationAnalysisClassmate():Map<String, String?>{
        return mapOf(
            "articleKey" to articleKey,
            "classKey" to classKey,
            "classRoomKey" to classRoomKey,
            "userUid" to userUid,
            "date" to date
        //TODO: NEED other analysis info
        )
    }
    fun getNotificationClassmate():Map<String, String?>{
        return mapOf(
            "classKey" to classKey,
            "classRoomKey" to classRoomKey,
            "userUid" to userUid,
            "date" to date
        )
    }

}
