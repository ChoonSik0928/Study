package com.choonsik.study.mvvm.data.domain.mapper

interface DomainMapper<T, DomainModel> {

    fun mapToDomainModel(model: T) : DomainModel

}