package com.choonsik.study.mvvm.data.repository

import androidx.lifecycle.LiveData
import com.choonsik.study.mvvm.data.domain.mapper.BreedMapper
import com.choonsik.study.mvvm.data.domain.model.Breed
import com.choonsik.study.mvvm.data.network.BreedService
import com.choonsik.study.mvvm.data.network.model.BreedDto
import com.choonsik.study.mvvm.data.network.response.BreedsResponse
import com.choonsik.study.mvvm.utils.Resource
import com.choonsik.study.mvvm.utils.performGetOperation
import javax.inject.Inject

class BreedRepository
@Inject constructor(
    private val breedService: BreedService,
    private val breedMapper: BreedMapper
) : BaseRepository() {
    fun getBreeds(page: Int) : LiveData<Resource<List<Breed>>> = performGetOperation(
        networkCall = {
            callNetwork { breedService.getBreeds(page) }
        },
        startMapper = {
            breedMapper.fromDomainList(it.breeds)
        }
    )

}