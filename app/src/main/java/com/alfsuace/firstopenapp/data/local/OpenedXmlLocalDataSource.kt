package com.alfsuace.firstopenapp.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit
import com.alfsuace.firstopenapp.domain.Hour
import com.google.gson.Gson
import java.util.Date

class OpenedXmlLocalDataSource(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("openedHour.txt", MODE_PRIVATE)
    private val serializer = Gson()

    fun getOpened(): Hour {
        val isEmpty = sharedPreferences.getString("open", null)==null
        val hour = Hour(0, Date(System.currentTimeMillis()))
        return if (isEmpty) {
            sharedPreferences.edit(){
                putString(serializer.toJson(hour), null)
            }
            hour
        } else {
            serializer.fromJson(
                sharedPreferences.getString("open", "empty"),
                Hour::class.java
            )
        }
    }

    fun saveHour(hour: Hour) {
        val serialized = serializer.toJson(hour)
        sharedPreferences.edit() {
            clear()
            putString("open", serialized)
            apply()
        }
    }

    fun setPlusOne() {
        val opened = getOpened().timesOpened + 1
        val newHour = Hour(opened, getOpened().date)
        saveHour(newHour)
    }

    fun setDate() {
        val atmDate = Date(System.currentTimeMillis())
        var newHour = Hour(getOpened().timesOpened, atmDate)
        saveHour(newHour)
    }
}