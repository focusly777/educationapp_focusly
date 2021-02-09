package io.focusly.focuslyeduteacher.util

import android.content.Context
import android.content.SharedPreferences

/**
 * 전역으로 사용할 sharedPreferences 객체
 * 하나의 파일에서 관리하여 쉽고 정확한 사용/관리
 * @AUTHOR 박기완
 * @VERSION
 * @DATE 2020/07/25 1:30 PM
 **/
class SharedPreferencesManager(context: Context) {
    val PREFERENCES_FILE_NAME = "FOCUSLY_PREFERENCES_FILE_NAME"
    val pref: SharedPreferences = context.getSharedPreferences(PREFERENCES_FILE_NAME, 0)

    //key list
    private val MYNUMBER = "MYNUMBER"
    private val UUID = "UUID"
    private val IS_ONLINE = "IS_ONLINE"
    private val OVERLAY_TEXT = "OVERLAY_TEXT"
    private val PLAY_MUSIC_NAME = "PLAY_MUSIC_NAME"
    private val FOLDER_ID = "FOLDER_ID"
    private val TODAY_READ_DATE = "TODAY_READ_DATE"
    private val TODAY_READ_TIME = "TODAY_READ_TIME"
    private val TODAT_READ_GOAL = "TODAT_READ_GOAL"

    private val CURRENT_ARTICLE_ID = "CURRENT_ARTICLE_ID"
    private val CURRENT_LAST_POSITION = "CURRENT_LAST_POSITION"
    private val CURRENT_SPEED = "CURRENT_SPEED"

    private val QUIZ_MODE = "QUIZ_MODE"
    private val FORCED_FOCUS_MODE = "FORCED_FOCUS_MODE"
    private val FOCED_FOCUS_TIME = "FOCED_FOCUS_TIME"
    private val REPEATABLE = "REPEATABLE"

    private val QUIZ_TIME = "QUIZ_TIME"
    private val QUIZ_COUNT = "QUIZ_COUNT"
    private val VIEW_QUIZ_AT_LAST = "VIEW_QUIZ_AT_LAST"

    private val READ_LIST = "READ_LIST"

    private val SCREEN_WIDTH = "SCREEN_WIDTH"
    private val SCREEN_HEIGHT = "SCREEN_HEIGHT"
    private val FONT_FAMILY = "FONT_FAMILY"

    private val DO_CLICK_RECENT_APP = "DO_CLICK_RECENT_APP"

    //value control
    var myNumber: Int
        get() = pref.getInt(MYNUMBER, -1)
        set(value) = pref.edit().putInt(MYNUMBER, value).apply()

    var uuid: String
        get() = pref.getString(UUID, "") ?: ""
        set(value) = pref.edit().putString(UUID, value).apply()

    var isOnline: Boolean
        get() = pref.getBoolean(IS_ONLINE, true)
        set(value) = pref.edit().putBoolean(IS_ONLINE, value).apply()

    var viewQuizAtLast: Boolean
        get() = pref.getBoolean(VIEW_QUIZ_AT_LAST, false)
        set(value) = pref.edit().putBoolean(VIEW_QUIZ_AT_LAST, value).apply()

    var overlayText: String
        get() = pref.getString(OVERLAY_TEXT, "") ?: ""
        set(value) = pref.edit().putString(OVERLAY_TEXT, value).apply()

    var playMusicName: String
        get() = pref.getString(PLAY_MUSIC_NAME, "OFF") ?: ""
        set(value) = pref.edit().putString(PLAY_MUSIC_NAME, value).apply()

    var quizMode: String
        get() = pref.getString(QUIZ_MODE, "ON") ?: ""
        set(value) = pref.edit().putString(QUIZ_MODE, value).apply()

    var forcedFocusMode: Boolean
        get() = pref.getBoolean(FORCED_FOCUS_MODE, false)
        set(value) = pref.edit().putBoolean(FORCED_FOCUS_MODE, value).apply()

    var focedFocusTime: Int
        get() = pref.getInt(FOCED_FOCUS_TIME, 0)
        set(value) = pref.edit().putInt(FOCED_FOCUS_TIME, value).apply()

    var repeatable: String
        get() = pref.getString(REPEATABLE, "")?: ""
        set(value) = pref.edit().putString(REPEATABLE, value).apply()

    var folderId: Int
        get() = pref.getInt(FOLDER_ID, 0)
        set(value) = pref.edit().putInt(FOLDER_ID, value).apply()

    var todayReadDate: String
        get() = pref.getString(TODAY_READ_DATE, "")?: ""
        set(value) = pref.edit().putString(TODAY_READ_DATE, value).apply()

    var todayReadTime: Int
        get() = pref.getInt(TODAY_READ_TIME, 0)
        set(value) = pref.edit().putInt(TODAY_READ_TIME, value).apply()

    var todayReadGoal: Boolean
        get() = pref.getBoolean(TODAT_READ_GOAL, false)
        set(value) = pref.edit().putBoolean(TODAT_READ_GOAL, value).apply()

    var currentArticleId: Int
        get() = pref.getInt(CURRENT_ARTICLE_ID, -1)
        set(value) = pref.edit().putInt(CURRENT_ARTICLE_ID, value).apply()

    var currentLastPosition: Int
        get() = pref.getInt(CURRENT_LAST_POSITION, -1)
        set(value) = pref.edit().putInt(CURRENT_LAST_POSITION, value).apply()

    var currentSpeed: Long
        get() = pref.getLong(CURRENT_SPEED, 100L)
        set(value) = pref.edit().putLong(CURRENT_SPEED, value).apply()

    var quizTime: Int
        get() = pref.getInt(QUIZ_TIME, 10)
        set(value) = pref.edit().putInt(QUIZ_TIME, value).apply()

    var quizCount: Int
        get() = pref.getInt(QUIZ_COUNT, 5)
        set(value) = pref.edit().putInt(QUIZ_COUNT, value).apply()

    var readList: String
        get() = pref.getString(READ_LIST, "")?: ""
        set(value) = pref.edit().putString(READ_LIST, value).apply()

    var screenWidth: Int
        get() = pref.getInt(SCREEN_WIDTH, 5)
        set(value) = pref.edit().putInt(SCREEN_WIDTH, value).apply()

    var screenHeight: Int
        get() = pref.getInt(SCREEN_HEIGHT, 5)
        set(value) = pref.edit().putInt(SCREEN_HEIGHT, value).apply()

    var fontFamily :Int
        get() = pref.getInt(FONT_FAMILY, 100)?: 100
        set(value) = pref.edit().putInt(FONT_FAMILY, value).apply()

    var doClickRecentApp: Boolean
        get() = pref.getBoolean(DO_CLICK_RECENT_APP, false)
        set(value) = pref.edit().putBoolean(DO_CLICK_RECENT_APP, value).apply()
}