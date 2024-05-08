package com.alfsuace.firstopenapp.domain

interface OpenedRepository {
    fun getOpened(): Int
    fun getHour(): Long
}