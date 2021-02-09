package io.focusly.focuslyedu.data.remote.source

data class UserNotificationData(
    var CLASS: HashMap<String, SubClassData>? = HashMap(),
    var ARTICLE: HashMap<String, ArticleData>? = HashMap(),
    var CLASSROOM_OPEN:HashMap<String, ClassroomData>? = HashMap()
    ) {
}