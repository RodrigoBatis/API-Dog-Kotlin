package com.example.api_kotlin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.api_kotlin.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPesquisar.setOnClickListener {getImage()}
    }

    private fun getImage() {


//        val urlImage = "https://s3.static.brasilescola.uol.com.br/be/2021/11/bandeira-do-brasil.jpg"
//        Picasso.get().load(urlImage).into(binding.imageDog)
    }
}