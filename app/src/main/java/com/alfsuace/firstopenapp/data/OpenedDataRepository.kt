package com.alfsuace.firstopenapp.data

import com.alfsuace.firstopenapp.data.local.OpenedXmlLocalDataSource
import com.alfsuace.firstopenapp.domain.Hour
import com.alfsuace.firstopenapp.domain.OpenedRepository

class OpenedDataRepository(
    private val openedXmlLocalDataSource: OpenedXmlLocalDataSource
) : OpenedRepository {
    override fun getOpened(): Int {
        val open = openedXmlLocalDataSource.getOpened()
        openedXmlLocalDataSource.setPlusOne()
        return open
    }

    override fun getHour(): Long {
        val date = openedXmlLocalDataSource
        date.setDate()
        return date.getDate()
    }


}