package com.choonsik.study.compose_ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.choonsik.study.R

/**
 * Fragment androidx.fragment.app.Fragment
 * prepareCall 메서드 이슈로
 * implementation 'androidx.fragment:fragment-ktx:1.3.0-rc01' 추가 후 해결
 */
class FragmentAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_add)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, TempFragment())
            .commit()
    }

    class TempFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return ComposeView(requireContext()).apply {
                setContent {
                    BasicText(text = "Temp")
                }
            }
        }

    }
}
