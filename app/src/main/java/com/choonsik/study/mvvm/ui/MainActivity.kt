package com.choonsik.study.mvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.choonsik.study.R
import com.choonsik.study.mvvm.data.network.BreedService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var breedService: BreedService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_main)

        CoroutineScope(IO).launch {
            val res = breedService.getBreeds(1)
            Timber.d("res = ${res}")
        }
    }
}