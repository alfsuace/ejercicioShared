package com.alfsuace.firstopenapp.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit
import com.google.gson.Gson

class OpenedXmlLocalDataSource (private val context: Context){
    private val sharedPreferences = context.getSharedPreferences("opened.txt", MODE_PRIVATE)

    fun getOpened(): Boolean {
        return sharedPreferences.getBoolean("open", false)
    }

    fun setOpened(){
        sharedPreferences.edit(){
            putBoolean("open", true)
            apply()
        }
    }
}