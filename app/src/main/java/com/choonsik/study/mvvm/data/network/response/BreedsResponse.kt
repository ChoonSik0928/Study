package com.choonsik.study.mvvm.data.network.response

import com.choonsik.study.mvvm.data.network.model.BreedDto
import com.google.gson.annotations.SerializedName

data class BreedsResponse(
    @SerializedName("data")
    val breeds: ArrayList<BreedDto>,
    @SerializedName("total")
    val totalCount: String
)