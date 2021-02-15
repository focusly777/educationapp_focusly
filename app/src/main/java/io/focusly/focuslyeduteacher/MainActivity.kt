package io.focusly.focuslyeduteacher

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import io.focusly.focuslyeduteacher.App.Companion.dLog
import io.focusly.focuslyeduteacher.App.Companion.util
import io.focusly.focuslyeduteacher.adapter.CompletionAdapter
import io.focusly.focuslyeduteacher.data.local.CompletionData
import io.focusly.focuslyeduteacher.databinding.ActivityMainBinding
import io.focusly.focuslyeduteacher.ui.classroom.ClassFragment
import io.focusly.focuslyeduteacher.ui.folder.FolderFragment
import io.focusly.focuslyeduteacher.ui.video.VideoFragment

class MainActivity : BaseActivity() {

    var state: Int? = null

    var classFragment: ClassFragment = ClassFragment()
    var folderFragment: FolderFragment = FolderFragment()
    var videoFragment: VideoFragment = VideoFragment()

    lateinit var completionAdatper:CompletionAdapter
    var completionDatas: ArrayList<CompletionData> = ArrayList()

    companion object {
        private const val ALL = 1000
        private const val CLASS = 0
        private const val FOLDER = 1
        private const val VIDEO = 2
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setTab(CLASS)
        loadCompletionData()
        setRv()
    }

    private fun loadCompletionData() {
        completionDatas.add(
            CompletionData().apply {
                this.title = "수업별 학생관리"
                this.content = "매일 책을 읽어 통계 수치를 높이고 더 많은 도서를 완독하세요!"
                this.currentCompletion = "14"
                this.maxCompletion = "20"
            }
        )
        completionDatas.add(
            CompletionData().apply {
                this.title = "진행중인 수업"
                this.content = "현재 진행중인 수업과 완료된 수업 입니다"
                this.currentCompletion = "3"
                this.maxCompletion = "5"
            }
        )
        completionDatas.add(
            CompletionData().apply {
                this.title = "퀴즈 목록"
                this.content = "완료하지 못한 퀴즈를 확인해보세요"
                this.currentCompletion = "7"
                this.maxCompletion = "10"
            }
        )
        completionDatas.add(
            CompletionData().apply {
                this.title = "수업별 학생관리"
                this.content = "매일 책을 읽어 통계 수치를 높이고 더 많은 도서를 완독하세요!"
                this.currentCompletion = "10"
                this.maxCompletion = "12"
            }
        )
        completionDatas.add(
            CompletionData().apply {
                this.title = "수업별 학생관리"
                this.content = "매일 책을 읽어 통계 수치를 높이고 더 많은 도서를 완독하세요!"
                this.currentCompletion = "24"
                this.maxCompletion = "28"
            }
        )
        completionDatas.add(
            CompletionData().apply {
                this.title = "수업별 학생관리"
                this.content = "매일 책을 읽어 통계 수치를 높이고 더 많은 도서를 완독하세요!"
                this.currentCompletion = "10"
                this.maxCompletion = "12"
            }
        )
        completionDatas.add(
            CompletionData().apply {
                this.title = "수업별 학생관리"
                this.content = "매일 책을 읽어 통계 수치를 높이고 더 많은 도서를 완독하세요!"
                this.currentCompletion = "24"
                this.maxCompletion = "28"
            }
        )
        completionDatas.add(
            CompletionData().apply {
                this.title = "수업별 학생관리"
                this.content = "매일 책을 읽어 통계 수치를 높이고 더 많은 도서를 완독하세요!"
                this.currentCompletion = "10"
                this.maxCompletion = "12"
            }
        )
        completionDatas.add(
            CompletionData().apply {
                this.title = "수업별 학생관리"
                this.content = "매일 책을 읽어 통계 수치를 높이고 더 많은 도서를 완독하세요!"
                this.currentCompletion = "24"
                this.maxCompletion = "28"
            }
        )
    }

    private fun setRv() {
        completionAdatper = CompletionAdapter(completionDatas)
        binding.rightpanelRV.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = completionAdatper
        }
    }

    fun onClick(view: View) {
        setTab(
            when (view) {
                binding.classCL -> CLASS
                binding.folderCL -> FOLDER
                binding.videoCL -> VIDEO
                else -> null
            }
        )
    }

    fun onClassFragmentClick(view: View) {
        classFragment.onClick(view)
    }

    fun onFolderFragmentClick(view: View) {
        folderFragment.onClick(view)
    }

    fun onVideoFragmentClick(view: View) {
        videoFragment.onClick(view)
    }


    private fun setTab(type: Int?) {
        state = type
        dLog.e(type.toString())
        if (type == null) {
            return
        } else {
            clearTabView(ALL)
            setTabView(type)
        }
    }

    private fun setTabView(type: Int) {
        val enabledBg = R.drawable._bg_main_tap
        val enalbedColor = R.color.maincolor

        val fragment = when (type) {
            CLASS -> {
                binding.classCL.setBackgroundResource(enabledBg)
                binding.classIV.setImageResource(R.drawable.icon_class_enabled)
                binding.classTV.setTextColor(resources.getColor(enalbedColor, null))
                showPanel(true)
                classFragment
            }
            FOLDER -> {
                binding.folderCL.setBackgroundResource(enabledBg)
                binding.folderIV.setImageResource(R.drawable.icon_article_enabled)
                binding.folderTV.setTextColor(resources.getColor(enalbedColor, null))
                showPanel(true)
                folderFragment
            }
            VIDEO -> {
                binding.videoCL.setBackgroundResource(enabledBg)
                binding.videoIV.setImageResource(R.drawable.icon_video_enabled)
                binding.videoTV.setTextColor(resources.getColor(enalbedColor, null))
                showPanel(false)
                videoFragment
            }
            else -> null
        }

        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.frame_content, fragment)
                .commit()
        }
    }

    private fun clearTabView(type: Int) {
        val disabledColor = R.color.tapbartype

        lateinit var layout:ConstraintLayout
        lateinit var imageView:ImageView
        lateinit var textView:TextView

        if(type == ALL) {
            clearTabView(CLASS)
            clearTabView(FOLDER)
            clearTabView(VIDEO)
            return
        }

        when(type) {
            CLASS -> {
                layout = binding.classCL
                imageView = binding.classIV
                textView = binding.classTV
            }
            FOLDER -> {
                layout = binding.folderCL
                imageView = binding.folderIV
                textView = binding.folderTV
            }
            VIDEO -> {
                layout = binding.videoCL
                imageView = binding.videoIV
                textView = binding.videoTV
            }
        }

        layout.setBackgroundResource(0)
        imageView.setImageResource(R.drawable.icon_class_disabled)
        textView.setTextColor(resources.getColor(disabledColor, null))
    }

    private fun showPanel(isShow: Boolean) {

        val params = binding.rightpanelCL.layoutParams as ViewGroup.LayoutParams
        if (isShow) {
            params.width = util.dpTopx(250).toInt()
            binding.rightpanelCL.layoutParams = params

            val distance: Float =
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0f, resources.displayMetrics)
            binding.rightpanelCL.animate().translationX(distance).setDuration(500).start()
        } else {
            params.width = -750
            binding.rightpanelCL.layoutParams = params

            val distance: Float =
                TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    300f,
                    resources.displayMetrics
                )
            binding.rightpanelCL.animate().translationX(distance).setDuration(500).start()
        }
    }
}