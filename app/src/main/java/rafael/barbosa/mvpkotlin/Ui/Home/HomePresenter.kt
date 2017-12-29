package rafael.barbosa.mvpkotlin.Ui.Home

import android.app.Activity
import android.content.Context
import android.util.Log
import com.prodeb.dev.app_caleola_kotlin.util_conection.TestarConexao
import rafael.barbosa.mvpkotlin.Domain.BookDomain
import rafael.barbosa.mvpkotlin.Domain.ResponseDomain
import rafael.barbosa.mvpkotlin.Model.Book

/**
 * Created by dev on 07/07/17.
 */
class HomePresenter(val context: Context,
                    override var view: HomeContract.UserView?)
    : HomeContract.UserActionsListener<HomeContract.UserView> {

    var livros:List<Book>? = null

    val bookDomain:BookDomain by lazy { BookDomain() }

    /**
     * Função chamada pela view ao clicar no botão
     */
    override fun loadBooks() {

        /**
         * Testamos se existe conexão, se sim chamamos o servidor
         */
        if (TestarConexao.VerificaConexao(context)) {

            view?.showProgressbar(true)

            bookDomain.getBookList(object : ResponseDomain<List<Book>>{
                override fun response(response: List<Book>?) {

                    if (response != null){

                        livros = response
                        view?.showBooks(livros!!)
                        view?.showEmpty(false)

                    }else{

                        view?.showEmpty(true)

                    }

                    view?.showProgressbar(false)
                }

            })

        }
    }


}