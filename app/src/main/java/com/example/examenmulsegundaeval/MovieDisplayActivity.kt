package com.example.examenmulsegundaeval


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examenmulsegundaeval.databinding.ActivityMovieDisplayBinding


class MovieDisplayActivity : AppCompatActivity() {
    lateinit var binding: ActivityMovieDisplayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var titulo = intent.getStringExtra("Titulo")
        var duracion = intent.getStringExtra("Duracion")
        var nomDir = intent.getStringExtra("Nombre")
        var anoPeli = intent.getStringExtra("Anio")

        binding.textTit.text= titulo
        binding.textDur.text= duracion
        binding.textNom.text= nomDir
        binding.textAn.text= anoPeli

        binding.nueva.setOnClickListener {
            val intent = android.content.Intent(this, MovieTitleActivity::class.java)
            startActivity(intent)
        }
        binding.atras2.setOnClickListener{
            val intent = android.content.Intent(this, MovieDisplayActivity::class.java)
            startActivity(intent)
        }
        

    }


}