package com.alfsuace.firstopenapp.domain

class GetOpenedUseCase(private val openedRepository: OpenedRepository) {

    operator fun invoke():Boolean{
        return openedRepository.getOpened()
    }
}