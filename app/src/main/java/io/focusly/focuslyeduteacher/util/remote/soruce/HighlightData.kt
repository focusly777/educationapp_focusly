package io.focusly.focuslyedu.data.remote.source

import androidx.annotation.Keep

@Keep
data class HighlightData(
    var highlightKey:String? = "",
    var color:String? = "#FFFFFF",
    var startPosition:String? = "-1",
    var endPosition:String? = "-1"

){
    fun getHighlight():Map<String, String?>{
        return mapOf(
            "highlightKey" to highlightKey,
            "color" to color,
            "startPosition" to startPosition,
            "endPosition" to endPosition
        )
    }
}