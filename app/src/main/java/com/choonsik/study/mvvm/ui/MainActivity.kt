package com.choonsik.study.mvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.switchMap
import com.choonsik.study.R
import com.choonsik.study.mvvm.data.domain.model.Breed
import com.choonsik.study.mvvm.data.network.BreedService
import com.choonsik.study.mvvm.data.repository.BreedRepository
import com.choonsik.study.mvvm.utils.Resource
import com.choonsik.study.mvvm.utils.Resource.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: BreedRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_main)

        CoroutineScope(IO).launch(Dispatchers.Main) {
            val res = repository.getBreeds(1)

            res.observe(this@MainActivity, {
                when (it.status) {
                    Status.LOADING -> {
                        Timber.d("start Loading")
                    }

                    Status.SUCCESS -> {
                        Timber.d("success ${it.data}")
                    }

                    Status.ERROR -> {
                        Timber.d("success ${it.message}")
                    }
                }

            })

        }
    }
}