package com.prodeb.dev.app_caleola_kotlin.API

import com.google.gson.JsonElement
import rafael.barbosa.mvpkotlin.model.Book
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by dev on 26/06/17.
 */

interface BaseAPI {

    @GET("aula/books.json")
    fun getBooks(): Call<List<Book>>


}
