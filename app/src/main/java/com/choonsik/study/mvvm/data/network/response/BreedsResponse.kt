package com.choonsik.study.mvvm.data.network.response

import com.choonsik.study.mvvm.data.domain.model.Breed
import com.google.gson.annotations.SerializedName

data class BreedsResponse(
    @SerializedName("data")
    val breeds: ArrayList<Breed>,
    @SerializedName("total")
    val totalCount: String
)