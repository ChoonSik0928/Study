package com.choonsik.study.mvvm.data.repository

import com.choonsik.study.mvvm.data.domain.model.Breed

interface BreedRepository {
    suspend fun getBreeds(page: Int) : List<Breed>
}