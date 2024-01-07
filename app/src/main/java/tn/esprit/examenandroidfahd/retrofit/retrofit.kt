package tn.esprit.examenandroidfahd.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofit {

    private const val BASE_URL = "http://192.168.1.115:9090/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}