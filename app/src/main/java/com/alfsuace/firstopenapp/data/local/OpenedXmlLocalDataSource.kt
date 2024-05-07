package com.alfsuace.firstopenapp.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit
import com.alfsuace.firstopenapp.domain.Hour
import com.google.gson.Gson

class OpenedXmlLocalDataSource(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("opened.txt", MODE_PRIVATE)
    private val serializer = Gson()

    fun getOpened(): Hour {
        val a = serializer.fromJson()

    }

    fun setPlusOne() {
        sharedPreferences.edit() {
            putInt("open", getOpened() + 1)
            apply()
        }
    }
}