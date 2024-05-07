package com.alfsuace.firstopenapp.data

import com.alfsuace.firstopenapp.data.local.OpenedXmlLocalDataSource
import com.alfsuace.firstopenapp.domain.OpenedRepository

class OpenedDataRepository(
    private val openedXmlLocalDataSource: OpenedXmlLocalDataSource
) : OpenedRepository {
    override fun getOpenedMoreThanFive(): Boolean {
        val opened = openedXmlLocalDataSource
        return if (opened.getOpened() < 5) {
            opened.setPlusOne()
            return false
        } else {
            return true
        }
    }

}