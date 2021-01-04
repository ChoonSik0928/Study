package com.choonsik.study.compose_ui.column_layouts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.choonsik.study.R

class ColumnLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScrollableColumn(
                modifier = Modifier.background(
                    color = Color(0xff555555)
                ).fillMaxHeight()
            ) {
//            Column {
                Image(
                    bitmap = imageFromResource(
                        res = resources,
                        resId = R.drawable.banner_choonsik
                    )
                )

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    BasicText(
                        text = "춘 - 식",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = TextUnit.Companion.Sp(26),
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(
                        modifier = Modifier.padding(top = 24.dp)
                    )

                    BasicText(
                        text = "ColumnLayout Study",
                        style = TextStyle(
                            color = Color(0xFFFFFFFF)
                        )
                    )
                }
            }
//            Image(bitmap = imageFromResource(res = resources, resId = R.drawable.banner_choonsik))
        }
    }
}