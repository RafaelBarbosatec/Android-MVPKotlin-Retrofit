package rafael.barbosa.mvpkotlin.Support.Conection

import com.google.gson.JsonElement
import rafael.barbosa.mvpkotlin.Model.Book
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by dev on 26/06/17.
 */

interface BaseAPI {

    /*@GET("aula/books.json")
    fun getBooks(): Call<List<Book>>*/

    @GET
    fun getGeneric(@Url url: String): Call<JsonElement>

    @FormUrlEncoded
    @POST
    fun postGeneric(@Url url: String, @FieldMap(encoded = true) params: Map<String, String>): Call<JsonElement>

    @FormUrlEncoded
    @PUT
    fun putGeneric(@Url url: String, @FieldMap(encoded = true) params: Map<String, String>): Call<JsonElement>


}
