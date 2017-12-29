package rafael.barbosa.mvpkotlin.Support.Manager

import com.google.gson.JsonElement
import rafael.barbosa.mvpkotlin.Support.Conection.BaseAPI
import rafael.barbosa.mvpkotlin.Support.Conection.RetrofitConection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by rafaelbarbosa on 26/12/17.
 */

object APIManager {

    private val url = "https://boleiro.tk/"
    private var baseapi : BaseAPI? = null

    init {
        baseapi = RetrofitConection(url).baseAPI
    }

    fun get(path: String, callback: APIResponse){

        baseapi?.getGeneric(path)
                ?.enqueue(object : Callback<JsonElement>{

                    override fun onResponse(call: Call<JsonElement>?, response: Response<JsonElement>?) {


                        if (response?.body() != null) {
                            callback.onResponse(response?.body(), response?.code())
                        }else{
                            callback.onFailure(Throwable())
                        }

                    }

                    override fun onFailure(call: Call<JsonElement>?, t: Throwable?) {

                        callback.onFailure(t)
                    }

                })
    }

    fun post(path: String, params: Map<String,String>, callback: APIResponse){

        baseapi?.postGeneric(path,params)
                ?.enqueue(object : Callback<JsonElement>{

                    override fun onResponse(call: Call<JsonElement>?, response: Response<JsonElement>?) {


                        callback.onResponse(response?.body(),response?.code())

                    }

                    override fun onFailure(call: Call<JsonElement>?, t: Throwable?) {

                        callback.onFailure(t)
                    }

                })
    }


    interface APIResponse{

        fun onResponse(response: JsonElement?, respondeCode : Int?)
        fun onFailure(t: Throwable?)

    }
}