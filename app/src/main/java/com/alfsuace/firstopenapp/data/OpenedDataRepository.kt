package com.alfsuace.firstopenapp.data

import com.alfsuace.firstopenapp.data.local.OpenedXmlLocalDataSource
import com.alfsuace.firstopenapp.domain.Hour
import com.alfsuace.firstopenapp.domain.OpenedRepository

class OpenedDataRepository(
    private val openedXmlLocalDataSource: OpenedXmlLocalDataSource
) : OpenedRepository {
    override fun getOpened(): Hour {
        val opened = openedXmlLocalDataSource.getOpened()
        openedXmlLocalDataSource.setPlusOne()
        openedXmlLocalDataSource.setDate()
        return opened
    }

}