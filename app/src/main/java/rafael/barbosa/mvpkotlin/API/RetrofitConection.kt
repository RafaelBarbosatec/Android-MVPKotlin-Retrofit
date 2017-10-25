package com.prodeb.dev.app_caleola_kotlin.API

import android.content.Context

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import rafael.barbosa.mvpkotlin.R

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by dev on 26/06/17.
 */

object RetrofitConection {

    val url = "https://boleiro.tk/"
    var baseAPI: BaseAPI

    init {

        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        baseAPI = retrofit.create(BaseAPI::class.java)

    }

}
