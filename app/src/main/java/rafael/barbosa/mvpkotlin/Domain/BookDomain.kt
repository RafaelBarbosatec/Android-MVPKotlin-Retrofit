package rafael.barbosa.mvpkotlin.Domain

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import rafael.barbosa.mvpkotlin.Model.Book
import rafael.barbosa.mvpkotlin.Support.Manager.APIManager

/**
 * Created by rafael on 29/12/17.
 */
class BookDomain{

    private val apiManager: APIManager = APIManager

    fun getBookList(responseDomain: ResponseDomain<List<Book>>){

        APIManager.get("aula/books.json",object : APIManager.APIResponse{
            override fun onResponse(response: JsonElement?, respondeCode: Int?) {

                    val listType = object : TypeToken<ArrayList<Book>>() {}.type

                    val bookList: List<Book> = Gson().fromJson(response, listType)

                    responseDomain.response(bookList)
            }

            override fun onFailure(t: Throwable?) {
                responseDomain.response(null)
            }

        })
    }
}