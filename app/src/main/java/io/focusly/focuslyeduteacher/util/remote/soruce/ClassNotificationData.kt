package io.focusly.focuslyedu.data.remote.source

data class ClassNotificationData(
    var ANALYSIS: HashMap<String, UserData>?= HashMap(),
    var CLASSMATE: HashMap<String, UserData>?=HashMap()
    ) {
}