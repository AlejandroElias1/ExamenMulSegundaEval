package com.example.examenmulsegundaeval

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examenmulsegundaeval.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var titulo = intent.getStringExtra("Titulo")
        var duracion = intent.getStringExtra("Duracion")
        binding.titulo1.text = titulo
        binding.duracion1.text = duracion

        binding.continuar1.setOnClickListener {
            val intent = android.content.Intent(this, MovieDisplayActivity::class.java)
            intent.putExtra("Titulo", binding.titulo1.text.toString())
            intent.putExtra("Duracion", binding.duracion1.text.toString())
            intent.putExtra("Nombre", binding.nomDir.text.toString())
            intent.putExtra("Anio", binding.anoPeli.text.toString())
            startActivity(intent)
        }

        //controlError()

        binding.atras.setOnClickListener{
            val intent = android.content.Intent(this, MovieTitleActivity::class.java)
            startActivity(intent)
        }

    }

    fun controlError(){
        if (binding.duracion1.text.toString().toInt()>0 || binding.nomDir.text.toString().isNotEmpty() || binding.titulo1.text.toString().isNotEmpty() || binding.anoPeli.text.toString().isNotEmpty()) {
            binding.continuar1.setOnClickListener {
                val intent = android.content.Intent(this, MovieDisplayActivity::class.java)
                intent.putExtra("Titulo", binding.titulo1.text.toString())
                intent.putExtra("Duracion", binding.duracion1.text.toString())
                intent.putExtra("Nombre", binding.nomDir.text.toString())
                intent.putExtra("Anio", binding.anoPeli.text.toString())
                startActivity(intent)
            }
        }else{
            showAlert()
        }
    }

    private fun showAlert(){
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Información")
        builder.setMessage("El campo introducido no es valido, Los campos no pueden estar vacios y la duracion no puede ser 0 min")
        builder.setPositiveButton("Aceptar", null)
        val dialog: android.app.AlertDialog = builder.create()
        dialog.show()
    }
}