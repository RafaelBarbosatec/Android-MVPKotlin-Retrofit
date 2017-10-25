package rafael.barbosa.mvpkotlin.Home

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.prodeb.dev.app_caleola_kotlin.API.BaseRequest
import com.prodeb.dev.app_caleola_kotlin.API.RetrofitConection
import com.prodeb.dev.app_caleola_kotlin.util_conection.TentarNovamente
import com.prodeb.dev.app_caleola_kotlin.util_conection.TestarConexao
import rafael.barbosa.mvpkotlin.model.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by dev on 07/07/17.
 */
class HomePresenter(val context: Context?,
                    override var view: HomeContract.UserView?)
    : HomeContract.UserActionsListener<HomeContract.UserView>, TentarNovamente {

    var livros:List<Book>? = null

    /**
     * Função chamada pela view ao clicar no botão
     */
    override fun loadBooks() {

        /**
         * Testamos se existe conexão, se sim chamamos o servidor
         */
        if (TestarConexao.VerificaConexao(context as Activity,this,"log")) {

            view?.showProgressbar(true)

            RetrofitConection.baseAPI.getBooks().enqueue(object : Callback<List<Book>>{

                override fun onResponse(call: Call<List<Book>>?, response: Response<List<Book>>?) {

                    if(response != null)
                    if(response.isSuccessful){

                        livros = response.body()

                        if (livros != null)
                        view?.showBooks(livros!!)

                    }

                    view?.showProgressbar(false)

                }

                override fun onFailure(call: Call<List<Book>>?, t: Throwable?) {

                    TestarConexao.calldialog(context, this@HomePresenter, "log")
                    view?.showProgressbar(false)

                }

            })

        }
    }

    /**
     * Função chamda ao clicar no botão "Tentar Novamente" no dialog de erro de conexão
     */
    override fun tentarNovamente(tag: String) {
        Log.i("LOG","tentarNovamente: "+tag)
        loadBooks()
    }

}