package com.alfsuace.firstopenapp.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit
import com.alfsuace.firstopenapp.domain.Hour
import com.google.gson.Gson
import java.util.Date

class OpenedXmlLocalDataSource(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("openedHourNs.txt", MODE_PRIVATE)
    private val serializer = Gson()

    fun getOpened(): Int {
        return sharedPreferences.getInt("opened", 1)
    }


    fun setPlusOne() {
        sharedPreferences.edit(){
            putInt("opened", getOpened()+1)
            apply()
        }
    }

    fun setDate() {
        sharedPreferences.edit(){
            putLong("date", System.currentTimeMillis())
            apply()
        }
    }

    fun getDate():Long{
        return sharedPreferences.getLong("date", 0)
    }
}