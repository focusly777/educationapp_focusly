package io.focusly.focuslyeduteacher.util

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.util.TypedValue
import android.widget.ScrollView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.gson.Gson
import io.focusly.focuslyeduteacher.App.Companion.dLog
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Whitelist
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


/**
 * 각종 유틸 함수들
 * @AUTHOR 박기완
 * @VERSION
 * @DATE 2020/07/25 1:30 PM
 **/
@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class FocuslyUtil(val mContext: Context) {
    private var firebaseDatabase = FirebaseDatabase.getInstance().reference
    private var exceptionQuizWordList: ArrayList<String> = ArrayList()

    init {
        firebaseDatabase.child("quiz_exception").addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (ds in snapshot.children) {
                    exceptionQuizWordList.add(ds.getValue(String::class.java) ?: "")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    fun max(a: Long, b: Long): Long {
        return if (a >= b) a else b
    }

    fun max(a: Int, b: Int): Int {
        return if (a >= b) a else b
    }

    fun max(a: Double, b: Double): Double {
        return if (a >= b) a else b
    }

    fun max(a: Float, b: Float): Float {
        return if (a >= b) a else b
    }

    fun min(a: Long, b: Long): Long {
        return if (a >= b) b else a
    }


    fun min(a: Int, b: Int): Int {
        return if (a >= b) b else a
    }

    fun min(a: Double, b: Double): Double {
        return if (a >= b) b else a
    }

    fun min(a: Float, b: Float): Float {
        return if (a >= b) b else a
    }


    fun dpTopx(a: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            a,
            mContext.resources.displayMetrics
        )
    }

    fun dpTopx(a: Int): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            a.toFloat(),
            mContext.resources.displayMetrics
        )
    }

    fun millsToTimeString(millsec: Double): String {
        return millsToTimeString(millsec.toLong())
    }

    fun millsToTimeString(millsec: Float): String {
        return millsToTimeString(millsec.toLong())
    }

    fun millsToTimeString(millsec: Long): String {
        val toSec: Int = max(((millsec + 1000) / 1000).toInt(), 0)

        val hours = toSec / 3600
        val mins = (toSec % 3600) / 60
        val secs = (toSec % 3600) % 60

        return if (hours != 0) {
            "${hours.toString().padStart(2, '0')}:${mins.toString().padStart(2, '0')}:${
                secs.toString().padStart(
                    2,
                    '0'
                )
            }"
        } else {
            "${mins.toString().padStart(2, '0')}:${secs.toString().padStart(2, '0')}"
        }
    }

    fun fullScrollImmediately(scrollView: ScrollView) {
        val lastChild = scrollView.getChildAt(scrollView.childCount - 1)
        val bottom = lastChild.bottom + scrollView.paddingBottom
        val delta = bottom - (scrollView.scrollY + scrollView.height)
        scrollView.scrollBy(0, delta)
    }

    fun getToday(): String {
        val calendar = Calendar.getInstance()
        val sdf = SimpleDateFormat("YYYY-MM-dd")
        return sdf.format(calendar.time)
    }

    fun ifEmpty(source: String?, defaultValue: String): String {
        if (source == null || source == "") {
            return defaultValue
        } else {
            return source
        }
    }

    fun secsToMinutes(secs: Int): String {
        val min = secs / 60
        val sec = secs % 60
        return "${min.toString().padStart(2, '0')}:${sec.toString().padStart(2, '0')}"
    }

    fun sortMapByValue(map: Map<String, Int>): LinkedHashMap<String, Int> {
        val entries: LinkedList<Map.Entry<String, Int>> = LinkedList(map.entries)
        entries.sortWith(Comparator { o1, o2 ->
            o2.value - o1.value
        })
        val result: LinkedHashMap<String, Int> = LinkedHashMap()
        for ((key, value) in entries) {
            result[key] = value
        }
        return result
    }

    fun arraylistTojsonString(list: ArrayList<Int>): String {
        return Gson().toJson(list)
    }

    fun jsonStringToArrayList(jsonString: String): ArrayList<Int> {
        val gson = Gson()
        var array =
            gson.fromJson(jsonString, Array<Int>::class.java)
        var list = array?.toCollection(ArrayList()) ?: ArrayList<Int>()
        return list
    }

    fun removeSpecialCharacters(str: String): String {
        for (exceptWord in exceptionQuizWordList) {
            if (str == exceptWord || str.equals(exceptWord, ignoreCase = true)) {
                return ""
            }
        }
        val regexSpecialCharacters1 = "\\p{Punct}"
        val regexSpecialCharacters2 = "[^\\w\\s]"
        val regexEmoji = "[\\uD83C-\\uDBFF\\uDC00-\\uDFFF]"
        return str.replace(regexSpecialCharacters2.toRegex(), "")
            .replace(regexSpecialCharacters1.toRegex(), "").replace(regexEmoji.toRegex(), "")
    }

    fun br2nl(html: String?): String? {
        if (html == null) return html
        val document: Document = Jsoup.parse(html)
        document.outputSettings(
            Document.OutputSettings().prettyPrint(false)
        ) //makes html() preserve linebreaks and spacing
        document.select("br").append("\\n")
        document.select("p").prepend("\\n\\n")
        var s: String = Jsoup.clean(
            document.html().replace("\\\\n", "\n"),
            "",
            Whitelist.none(),
            Document.OutputSettings().prettyPrint(false)
        )

        s = s.replace("&amp;", "&")
        s = s.replace("&nbsp;", "")
        s = s.replace("\\n", "")
        for (i in 1..4) {
            s = s.replace("\t", " ")
            s = s.replace("  ", " ")
            s = s.replace(" \n", "\n")
            s = s.replace("\n ", "\n")
        }

        for (i in 1..4) {
            s = s.replace("\n\n\n", "\n")
        }

        return s
    }

    fun getPathFromUri(uri: Uri?): String? {
        if (uri == null) {
            return ""
        }

        val cursor: Cursor? = mContext.contentResolver.query(uri, null, null, null, null)
        cursor?.moveToNext()
        var path = cursor?.getString(cursor.getColumnIndex("_data"))
        cursor?.close()

        dLog.e("path $path")
        return path
    }

    fun getFileFromUri(uri: Uri): File {
        return File(getPathFromUri(uri))
    }

    fun getFileNameFromUri(uri: Uri?): String {
        return try {
            val filenameList = getPathFromUri(uri)?.split("/")
            val filename = filenameList?.get(filenameList.size - 1).toString()
            filename
        } catch (e: Exception) {
            "noName"
        }
    }
}