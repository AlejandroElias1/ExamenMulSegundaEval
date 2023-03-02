package com.example.examenmulsegundaeval

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examenmulsegundaeval.databinding.ActivityMovietitleBinding


class MovieTitleActivity : AppCompatActivity() {

    lateinit var binding: ActivityMovietitleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovietitleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.continuar.setOnClickListener {
            val intent = android.content.Intent(this, MovieDetailsActivity::class.java)
            intent.putExtra("Titulo", binding.titulo.text.toString() )
            intent.putExtra("Duracion", binding.duracion.text.toString())
            startActivity(intent)
        }


        //controlError()


    }

    fun controlError(){
        if (binding.titulo.text.toString().isNotEmpty() || binding.duracion.text.toString().toInt()>0) {
            binding.continuar.setOnClickListener {
                val intent = android.content.Intent(this, MovieDetailsActivity::class.java)
                intent.putExtra("Titulo", binding.titulo.text.toString() )
                intent.putExtra("Duracion", binding.duracion.text.toString())
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