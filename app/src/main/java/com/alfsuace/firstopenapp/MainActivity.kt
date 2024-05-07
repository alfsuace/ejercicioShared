package com.alfsuace.firstopenapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alfsuace.firstopenapp.data.OpenedDataRepository
import com.alfsuace.firstopenapp.data.local.OpenedXmlLocalDataSource
import com.alfsuace.firstopenapp.domain.GetOpenedUseCase
import com.alfsuace.firstopenapp.domain.OpenedRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initOpened()
    }

    private fun initOpened() {
        val openedRepository:OpenedRepository = OpenedDataRepository(
            OpenedXmlLocalDataSource(applicationContext)
        )
        val isOpen= GetOpenedUseCase(openedRepository).invoke()
        updateVisibility(isOpen<5)
    }
    private fun updateVisibility(isOpen: Boolean) {
        val visualizerTextView = findViewById<TextView>(R.id.visualizer)
        visualizerTextView.visibility = if (isOpen) View.VISIBLE else View.GONE
    }

}