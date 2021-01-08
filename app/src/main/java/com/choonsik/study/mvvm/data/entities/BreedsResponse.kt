package com.choonsik.study.mvvm.data.entities

import com.google.gson.annotations.SerializedName

data class BreedsResponse(
    @SerializedName("data")
    val breeds: ArrayList<Breed>,
    @SerializedName("total")
    val totalCount: String
)