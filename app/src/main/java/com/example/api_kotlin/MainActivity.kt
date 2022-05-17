package com.example.api_kotlin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.api_kotlin.databinding.ActivityMainBinding
import com.example.api_kotlin.sla.Endpoint
import com.google.gson.JsonObject
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPesquisar.setOnClickListener {getImage()}
    }

    private fun getImage() {
        val url = "https://dog.ceo"
        val retrofitcliente = retrofitinstance(url)
        val Endpoint = retrofitcliente.create(Endpoint::class.java)
        val raca = binding.editRaca.text.toString()

        Endpoint.getDog(raca).enqueue(object : Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val urlImage = response.body()?.get("message")?.asString
                Picasso.get().load(urlImage).into(binding.imageDog)
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Toast.makeText(applicationContext, "Erro ao acessar", Toast.LENGTH_LONG)
            }

        })

//        val urlImage = "https://s3.static.brasilescola.uol.com.br/be/2021/11/bandeira-do-brasil.jpg"
//        Picasso.get().load(urlImage).into(binding.imageDog)
    }

    private fun retrofitinstance(url: String): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}