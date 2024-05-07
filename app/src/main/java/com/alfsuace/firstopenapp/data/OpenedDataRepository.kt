package com.alfsuace.firstopenapp.data

import com.alfsuace.firstopenapp.data.local.OpenedXmlLocalDataSource
import com.alfsuace.firstopenapp.domain.OpenedRepository

class OpenedDataRepository(
    private val openedXmlLocalDataSource: OpenedXmlLocalDataSource
) : OpenedRepository {

    override fun getOpened(): Boolean {
        val result = openedXmlLocalDataSource.getOpened()
        return if (!result) {
            openedXmlLocalDataSource.setOpened()
            return result
        } else {
            return result
        }
    }

}