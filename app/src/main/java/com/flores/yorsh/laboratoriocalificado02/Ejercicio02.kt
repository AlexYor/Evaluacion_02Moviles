package com.flores.yorsh.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.flores.yorsh.laboratoriocalificado02.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Ajustar el padding para las barras del sistema usando el ID correcto del ConstraintLayout
        ViewCompat.setOnApplyWindowInsetsListener(binding.clEjercicio02) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        observeButtons()
    }

    private fun observeButtons() {
        binding.btnRegistrar.setOnClickListener {
            goDetailActivity()
        }
    }

    private fun goDetailActivity() {
        // Obtener datos de los campos
        val nombreCliente = binding.edtNombreCliente.text.toString()
        val numeroCliente = binding.edtNumeroCliente.text.toString()
        val productos = binding.edtProductos.text.toString()
        val ciudad = binding.edtCiudad.text.toString()
        val direccion = binding.edtDireccion.text.toString()

        // Crear el intent para la segunda actividad
        val intent = Intent(this, Ejercicio02_Pedido::class.java)

        // Pasar los datos como extras
        intent.putExtra("NOMBRE_CLIENTE", nombreCliente)
        intent.putExtra("NUMERO_CLIENTE", numeroCliente)
        intent.putExtra("PRODUCTOS", productos)
        intent.putExtra("CIUDAD", ciudad)
        intent.putExtra("DIRECCION", direccion)

        // Iniciar la segunda actividad
        startActivity(intent)
    }
}
