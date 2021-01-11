package com.choonsik.study.mvvm.data.domain.mapper

import com.choonsik.study.mvvm.data.domain.model.Breed
import com.choonsik.study.mvvm.data.network.model.BreedDto

class BreedMapper : DomainMapper<BreedDto, Breed> {
    override fun mapToDomainModel(dto: BreedDto): Breed {
        return Breed(
            name = dto.breed,
            country = dto.country,
            origin = dto.origin,
            coat = dto.coat,
            pattern = dto.pattern
        )
    }

    fun fromDomainList(entities: List<BreedDto>): List<Breed> {
        return entities.map { mapToDomainModel(it)}
    }
}