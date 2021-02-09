package io.focusly.focuslyedu.data.remote.source

import androidx.annotation.Keep
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

@Keep
data class QuizData(
    var quizKey:String? ="",
    var question:String? = "",
    var case: HashMap<String, String>? = HashMap(),
    var answer:String?= "",
    var startPosition:String? = "-1",
    var endPosition:String?="-1",
    //user의 shared article
    var myAnswer:String?= "",

    //class의 Article
    var quizStatus:String?="OFF",

    var ownerUid:String?=""
) {
    fun getUserSharedArticleQuiz():Map<String, Any?>{
        return mapOf(
            "quizKey" to quizKey,
            "startPosition" to startPosition,
            "endPosition" to endPosition,
            "question" to question,
            "case" to case,
            "answer" to answer,
            "myAnswer" to myAnswer
        )
    }
    fun getClassArticleQuiz():Map<String, Any?>{
        return mapOf(
            "quizKey" to quizKey,
            "startPosition" to startPosition,
            "endPosition" to endPosition,
            "question" to question,
            "case" to case,
            "answer" to answer,
            "quizStatus" to quizStatus,
            "ownerUid" to ownerUid
        )
    }
}
