package com.alfsuace.firstopenapp.data

import com.alfsuace.firstopenapp.data.local.OpenedXmlLocalDataSource
import com.alfsuace.firstopenapp.domain.OpenedRepository

class OpenedDataRepository(
    private val openedXmlLocalDataSource: OpenedXmlLocalDataSource
) : OpenedRepository {
    override fun getOpened(): Int {
        val opened = openedXmlLocalDataSource.getOpened()
        openedXmlLocalDataSource.setPlusOne()
        return opened
    }

}