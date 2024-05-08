package com.alfsuace.firstopenapp.domain

class GetHourUseCase(private val repository: OpenedRepository) {

    operator fun invoke():Long{
        return repository.getHour()
    }
}