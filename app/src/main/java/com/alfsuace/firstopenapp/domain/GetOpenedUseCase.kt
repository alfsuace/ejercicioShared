package com.alfsuace.firstopenapp.domain

class GetOpenedUseCase(private val openedRepository: OpenedRepository) {

    operator fun invoke():Int{
        return openedRepository.getOpened()
    }
}