package com.bks.imdumb.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.bks.imdumb.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * SOLID: Liskov Substitution Principle (LSP)
 * MainActivity puede ser tratada como una HomeContract.View (o cualquier otra vista)
 * por el Presenter sin que este necesite conocer detalles de la implementación de la Activity.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilita el modo Edge-to-Edge para un diseño más moderno e inmersivo
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)
    }
}
