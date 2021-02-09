package io.focusly.focuslyedu.data.remote.search

import androidx.annotation.Keep

@Keep
data class SearchData(
    var title: String = "",
    var link: String = "",
    var description: String = "",
    var bloggername: String = "",
    var bloggerlink: String = "",
    var postdate: String = "",
    var imgUrl: Any? = null
) {
}