package com.alfsuace.firstopenapp.domain

interface OpenedRepository {
    fun getOpenedMoreThanFive(): Boolean
}