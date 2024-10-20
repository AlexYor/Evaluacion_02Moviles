package com.flores.yorsh.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Ajustar el padding para las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Navegar hacia Ejercicio01

        //val intent = Intent(this, Ejercicio01::class.java)
        //startActivity(intent)

        // Navegar hacia Ejercicio02
        val intent = Intent(this, Ejercicio02::class.java)
        startActivity(intent)

        // Finalizar MainActivity para que no se pueda regresar a ella
        finish()
    }
}
