package com.prodeb.dev.app_caleola_kotlin.API

import retrofit2.Call
import retrofit2.http.*

/**
 * Created by dev on 26/06/17.
 */

interface BaseAPI {

    /** EXEMPLOS
     *
     * @GET("eventos")
    fun getEventosGeral(@Query("usuario") id_usuario: String): Call<BaseRequest>

    @GET("eventos/{id_evento}")
    fun getEvento(@Path("id_evento") id_evento: String): Call<BaseRequest>

    @FormUrlEncoded
    @POST("eventos_participar")
    fun participarEvento(@Field("id_usuario") id_usuario: String, @Field("id_evento") id_evento: String, @Field("sexo") sexo: String, @Field("setor") setor: String, @Field("caleolado") caleolado: String): Call<BaseRequest>

    @FormUrlEncoded
    @POST("pagar")
    fun pagar(@Field("id_usuario") id_usuario: String, @Field("id_evento") id_evento: String, @Field("banco") banco: Int, @Field("valor") valor: String, @Field("comprovante") comprovante: String): Call<BaseRequest>


     */

    @GET("usuarios")
    fun getUsuarios(): Call<BaseRequest>


}
