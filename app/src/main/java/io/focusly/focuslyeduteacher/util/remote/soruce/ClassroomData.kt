package io.focusly.focuslyedu.data.remote.source

import androidx.annotation.Keep

@Keep
data class ClassroomData(
    //Field
    var classRoomKey:String? ="",
    var classRoomName:String? = "",
    var classRoomTime:String? = "",
    var classRoomLocation:String?="",
    var classRoomNextOpenTime:String?="",
    var classRoomNextCloseTime:String? = "",
    var classRoomNextLocation:String?="",
    var classRoomStatus:String?="",//OPEN/CLOSE
    //for notification
    var classKey:String?="",
    var articleKey:String?="",
    var openTime:String?="",
    var closeTime:String?="",
    var userUid:String?="",
    var date:String?="",
    //closeTime

    //For Analysis in class
    var ARTICLE:HashMap<String, ArticleData>? = HashMap()
) {
    fun getClassClassRoom(): Map<String, String?> {
        return mapOf(
            "classRoomKey" to classRoomKey,
            "classRoomName" to classRoomName,
            "classRoomTime" to classRoomTime,
            "classRoomLocation" to classRoomLocation,
            "classRoomNextOpenTime" to classRoomNextOpenTime,
            "classRoomNextCloseTime" to classRoomNextCloseTime,
            "classRoomNextLocation" to classRoomNextLocation,
            "classRoomStatus" to classRoomStatus
        )
    }
    fun getClassAnalysisClassRoom():Map<String, String?> {
        return mapOf(
            "classRoomKey" to classRoomKey,
            "classRoomName" to classRoomName
        )
    }
    fun getNotificationClassRoom():Map<String, String?>{
        return mapOf(
            "articleKey" to articleKey,
            "classKey" to classKey,
            "classRoomKey" to classRoomKey,
            "openTime" to openTime,
            "closeTime" to closeTime,
            "userUid" to userUid,
            "date" to date
        )
    }
}
