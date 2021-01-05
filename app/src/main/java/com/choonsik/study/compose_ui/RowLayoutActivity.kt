package com.choonsik.study.compose_ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class RowLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color(0xFFddeFFF))
                        .height(200.dp)
                        .border(border = BorderStroke(width = 1.dp, color = Color.Red)),
//                    verticalArrangement = Arrangement.Center
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    BasicText(
                        text = "Item1",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    BasicText(
                        text = "Item1",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }

                Spacer(modifier = Modifier.padding(20.dp))

                Row(
                    modifier = Modifier.width(200.dp)
                        .background(Color(0xFFddeFFF))
                        .height(200.dp)
                        .border(border = BorderStroke(width = 1.dp, color = Color.Red)),
                    horizontalArrangement = Arrangement.Center
                    ) {
                    BasicText(
                        text = "Item1",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }

        }
    }
}