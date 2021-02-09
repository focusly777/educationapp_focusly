package io.focusly.focuslyedu.data.remote.source

import androidx.annotation.Keep
//2021/02/03
@Keep
data class BookmarkData(
    //Field
    var bookmarkKey:String?="",
    var bookmarkTitle:String?="",
    var bookmarkPosition:String?=""
){
    fun getBookmark():Map<String, String?>{
        return mapOf(
            "bookmarkKey" to bookmarkKey,
            "bookmarkTitle" to bookmarkTitle,
            "bookmarkPosition" to bookmarkPosition
        )
    }
}