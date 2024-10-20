package com.flores.yorsh.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.flores.yorsh.laboratoriocalificado02.databinding.ActivityEjercicio02PedidoBinding

class Ejercicio02_Pedido : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02PedidoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02PedidoBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Ajustar el padding para las barras del sistema usando el ID correcto del ConstraintLayout
        ViewCompat.setOnApplyWindowInsetsListener(binding.clEjercicio02Pedido) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        showInformation(intent.extras)
        observeButtons()
    }

    private fun showInformation(bundle: Bundle?) {
        if (bundle != null) {
            val nombreCliente = bundle.getString("NOMBRE_CLIENTE")
            val numeroCliente = bundle.getString("NUMERO_CLIENTE")
            val productos = bundle.getString("PRODUCTOS")
            val ciudad = bundle.getString("CIUDAD")
            val direccion = bundle.getString("DIRECCION")

            binding.tvNombreCliente.text = "Nombre Cliente: $nombreCliente"
            binding.tvNumeroCliente.text = "Número Cliente: $numeroCliente"
            binding.tvProductos.text = "Productos: $productos"
            binding.tvCiudad.text = "Ciudad: $ciudad"
            binding.tvDireccion.text = "Dirección: $direccion"
        }
    }

    private fun observeButtons() {
        binding.imbWsp.setOnClickListener {
            goWsp()
        }

        binding.imbDial.setOnClickListener {
            goDial()
        }

        binding.imbMaps.setOnClickListener {
            goMaps()
        }
    }

    private fun goWsp() {
        val numeroCliente = binding.tvNumeroCliente.text.toString().replace("Número Cliente: ", "")
        val mensaje = "Hola, ${binding.tvNombreCliente.text} tus productos están en camino a la dirección: ${binding.tvDireccion.text}"

        val intentWsp = Intent(Intent.ACTION_VIEW)
        intentWsp.data = Uri.parse("https://wa.me/$numeroCliente?text=$mensaje")

        startActivity(intentWsp)
    }

    private fun goDial() {
        val numeroCliente = binding.tvNumeroCliente.text.toString().replace("Número Cliente: ", "")

        val intentDial = Intent(Intent.ACTION_DIAL)
        intentDial.data = Uri.parse("tel:$numeroCliente")

        startActivity(intentDial)
    }

    private fun goMaps() {
        val direccion = binding.tvDireccion.text.toString().replace("Dirección: ", "")
        val uri = Uri.parse("geo:0,0?q=$direccion")

        val intentMaps = Intent(Intent.ACTION_VIEW, uri)
        intentMaps.setPackage("com.google.android.apps.maps")

        startActivity(intentMaps)
    }
}
