package io.focusly.focuslyedu.data.remote.source
import androidx.annotation.Keep

//2021/02/03
@Keep
data class ArticleData(
    //Field
    var articleKey:String?="",
    var articleTitle:String?="",
    var author:String?="",
    var createdDate:String?="",
    var folderKey:String?="",
    var fullLength:String?="",
    var startReadPosition:String?="",
    var lastReadPosition:String?="",
    var latelyPosition:String?="",
    var inboxIndex:String?="",

    var ownerUid:String?="",
    var subTitle:String?="",

    //for shared article
    var classKey:String?="",
    var publishStatus:String?="",

    //for deleted article
    var deletedUid:String?="",
    var deletedDate:String?="",

    //for notification
    var classRoomKey:String?="",
    var date:String?="",
    var userUid:String?="",
    //Directory
    var BOOKMARK:HashMap<String, BookmarkData>? = HashMap(),
    var HIGHLIGHT:HashMap<String, HighlightData>? = HashMap(),
    var QUIZ:HashMap<String,QuizData>? = HashMap(),

    //for CLASS/ANALYSIS(classroom)/ARTICLE/CLASSMATE
    var CLASSMATE:HashMap<String,UserData>? = HashMap()
) {
    //USER/ARTICLE
    fun getUserArticle(): Map<String, String?> {
        return mapOf(
            "articleKey" to articleKey,
            "articleTitle" to articleTitle,
            "author" to author,
            "createdDate" to createdDate,
            "folderKey" to folderKey,
            "fullLength" to fullLength,
            "startReadPosition" to startReadPosition,
            "lastReadPosition" to lastReadPosition,
            "latelyPosition" to latelyPosition,
            "inboxIndex" to inboxIndex,
            "ownerUid" to ownerUid,
            "subTitle" to subTitle
        )
    }
    //USER/SHARED_ARTICLE
    fun getUserSharedArticle(): Map<String, String?> {
        return mapOf(
            "articleKey" to articleKey,
            "articleTitle" to articleTitle,
            "author" to author,
            "createdDate" to createdDate,
            "classKey" to classKey,
            "fullLength" to fullLength,
            "startReadPosition" to startReadPosition,
            "lastReadPosition" to lastReadPosition,
            "latelyPosition" to latelyPosition,
            "inboxIndex" to inboxIndex,
            "ownerUid" to ownerUid,
            "subTitle" to subTitle
        )
    }
    fun getUserDeletedArticle(): Map<String, String?> {
        return mapOf(
            "articleKey" to articleKey,
            "articleTitle" to articleTitle,
            "author" to author,
            "createdDate" to createdDate,
            "deletedDate" to deletedDate,
            "folderKey" to folderKey,
            "fullLength" to fullLength,
            "startReadPosition" to startReadPosition,
            "lastReadPosition" to lastReadPosition,
            "latelyPosition" to latelyPosition,
            "ownerUid" to ownerUid,
            "subTitle" to subTitle
        )
    }
    //class/analysis/article
    fun getClassAnalysisArticle():Map<String, String?> {
        return mapOf(
            "articleKey" to articleKey,
            "articleTitle" to articleTitle
        )
    }
    //class/article
    fun getClassArticle(): Map<String, String?> {
        return mapOf(
            "articleKey" to articleKey,
            "articleTitle" to articleTitle,
            "ownerUid" to ownerUid,
            "subTitle" to subTitle,
            "author" to author,
            "fullLength" to fullLength,
            "createdDate" to createdDate,
            "publishStatus" to publishStatus

        )
    }
    fun getClassDeletedArticle(): Map<String, String?> {
        return mapOf(
            "articleKey" to articleKey,
            "articleTitle" to articleTitle,
            "ownerUid" to ownerUid,
            "subTitle" to subTitle,
            "author" to author,
            "fullLength" to fullLength,
            "createdDate" to createdDate,
            "publishStatus" to publishStatus,
            "deletedDate" to deletedDate,
            "deletedUid" to deletedUid

        )
    }

    fun getNotificationArticle(): Map<String, String?> {
        return mapOf(
            "articleKey" to articleKey,
            "classKey" to classKey,
            "classRoomKey" to classRoomKey,
            "userUid" to userUid,
            "date" to date
        )
    }
}
