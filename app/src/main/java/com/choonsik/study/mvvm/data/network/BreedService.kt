package com.choonsik.study.mvvm.data.network

import com.choonsik.study.mvvm.data.network.response.BreedsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface BreedService {

    @GET("breeds")
    suspend fun getBreeds(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 10
    ): Response<BreedsResponse>
}