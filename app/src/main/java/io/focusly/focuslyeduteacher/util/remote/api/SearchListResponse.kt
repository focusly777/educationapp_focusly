package io.focusly.focuslyedu.data.remote.search

import androidx.annotation.Keep

/**
 * api 호출 후 데이터 응답을 받는 클래스
 * @AUTHOR 박기완
 * @VERSION
 * @DATE 2020/07/25 1:18 PM
 **/
@Keep
data class SearchListResponse(
    var lastBuildDate: String = "",
    var total: Long = 0,
    var start: Int = 0,
    var display: Int = 0,
    var items: ArrayList<SearchData?>? = ArrayList()
) {
}