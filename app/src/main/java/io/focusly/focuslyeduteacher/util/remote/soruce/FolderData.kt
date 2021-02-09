package io.focusly.focuslyedu.data.remote.source

import androidx.annotation.Keep

@Keep
data class FolderData(
    //Field
    var folderKey:String?="",
    var folderTitle:String?="",
    var folderIndex:String?="0",
    var folderSubtitle:String?="",//optional
    //Directory
    var ARTICLE: HashMap<String, String>? = HashMap()//ARTICLE KEY, INDEX
) {
    fun getFolder():Map<String, String?>{
        return mapOf(
            "folderKey" to folderKey,
            "folderTitle" to folderTitle,
            "folderIndex" to folderIndex,
            "folderSubtitle" to folderSubtitle
        )
    }
}
