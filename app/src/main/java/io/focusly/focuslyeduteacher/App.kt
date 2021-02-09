package io.focusly.focuslyeduteacher

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import io.focusly.focuslyeduteacher.util.FocuslyUtil
import io.focusly.focuslyeduteacher.util.SharedPreferencesManager


/**
 * 전역 앱 객체. sharedPref, log, util 을 여기서 관리함
 * @AUTHOR 박기완
 * @VERSION
 * @DATE 2020/07/25 1:31 PM
 **/
class App : Application() {

    companion object {
        fun dToast(msg: Any) {
            if (DEBUG) {
                Toast.makeText(App.context, msg.toString(), Toast.LENGTH_SHORT).show()
            }
        }

        var DEBUG: Boolean = false

        lateinit var context: Context
        lateinit var pref: SharedPreferencesManager
        lateinit var dLog: Dlog
        lateinit var dToast: Dtoast
        lateinit var util: FocuslyUtil
    }

    override fun onCreate() {
        context = this
        DEBUG = isDebuggable(this)

        pref = SharedPreferencesManager(applicationContext)
        dLog = Dlog()
        dToast = Dtoast()
        util = FocuslyUtil(applicationContext)
        super.onCreate()
    }

    fun isDebuggable(context: Context): Boolean {
        var debuggable = false
        val pm: PackageManager = context.getPackageManager()
        try {
            val appinfo = pm.getApplicationInfo(context.getPackageName(), 0)
            debuggable = 0 != appinfo.flags and ApplicationInfo.FLAG_DEBUGGABLE
        } catch (e: PackageManager.NameNotFoundException) { /* debuggable variable will remain false */
        }
        return debuggable
    }



    /**
     *  @brief      Debug 환경에서만 사용할 수 있는 Toast클래스
     *  @author     박기완
     *  @date       2020-12-22
     *  Copyright   Gilbert Park
     */
    @Deprecated("user function dToast")
    class Dtoast {
        fun show(msg: Any?) {
            if (DEBUG) {
                Toast.makeText(App.context, msg.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     *  @brief      Debug 환경에서만 사용할 수 있는 Log클래스
     *  @author     이현기2
     *  @date       2018-01-25 오전 11:24
     *  Copyright   TedPark
     */
    class Dlog {

        /** Log Level Error **/
        fun e(message: String) {
            if (DEBUG) {
                Log.e(buildLogTag(), message);
            }
        }

        /** Log Level Warning **/
        fun w(message: String) {
            if (DEBUG) {
                Log.w(buildLogTag(), message);
            }
        }

        /** Log Level Information **/
        fun i(message: String) {
            if (DEBUG) {
                Log.i(buildLogTag(), message);
            }
        }

        /** Log Level Debug **/
        fun d(message: String) {
            if (DEBUG) {
                Log.d(buildLogTag(), message);
            }
        }

        /** Log Level Verbose **/
        fun v(message: String) {
            if (DEBUG) {
                Log.v(buildLogTag(), message);
            }
        }


        private fun buildLogTag(): String {
            val ste: StackTraceElement = Thread.currentThread().stackTrace[4]
            var sb: StringBuilder = StringBuilder()
            sb.append("[")
            sb.append(ste.fileName.replace(".java", ""))
            sb.append("::")
            sb.append(ste.methodName)
            sb.append("]")

            return sb.toString()
        }

        fun buildLogMsg(message: String): String {
            val ste: StackTraceElement = Thread.currentThread().stackTrace[4]
            var sb: StringBuilder = StringBuilder()
            sb.append("[")
            sb.append(ste.fileName.replace(".java", ""))
            sb.append("::")
            sb.append(ste.methodName)
            sb.append("]")
            sb.append(message)

            return sb.toString()
        }
    }
}