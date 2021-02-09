package io.focusly.focuslyedu.data.remote.source

import androidx.annotation.Keep

@Keep
data class UserSummaryData(
    var personalID: String? = "",
    var userName: String? = "",
    var userType: String? = "",
    var userUID: String? = "",
    //department/subject/classroom/classmate의 user를 위해 사용
    var correctQuizCount: Int? = 0,
    //department/subject/classroom/classmate의 user를 위해 사용
    var totalQuizCount: Int? = 0,
    //department/subject/classroom/classmate의 user를 위해 사용
    var totalReadingTime: Int? = 0,

    //user_summary/group/member와 user_summary/manager를 위해 사용
    var classrooms: HashMap<String, ClassroomData>? = HashMap(),
    //department/subject/classroom/classmate의 user를 위해 사용
    var classmateArticles: HashMap<String, ClassroomData>? = HashMap()
) {
}
