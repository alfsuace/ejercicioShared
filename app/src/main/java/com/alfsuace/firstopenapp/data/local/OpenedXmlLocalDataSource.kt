package com.alfsuace.firstopenapp.data.local

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit

class OpenedXmlLocalDataSource (private val context: Context){
    private val sharedPreferences = context.getSharedPreferences("opened.txt", MODE_PRIVATE)

    fun getOpened(): Int {
        return sharedPreferences.getInt("open", 0)
    }

    fun setPlusOne(){
        sharedPreferences.edit(){
            putInt("open", getOpened()+1)
            apply()
        }
    }
}