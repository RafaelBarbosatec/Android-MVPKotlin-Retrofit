package rafael.barbosa.mvpkotlin.Home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import rafael.barbosa.mvpkotlin.Adapters.BooksAdapter

import rafael.barbosa.mvpkotlin.R
import rafael.barbosa.mvpkotlin.model.Book

class HomeActivity : AppCompatActivity() , HomeContract.UserView{

    var adapter:BooksAdapter? = null
    /**
     * Instanciamos de forma preguiçosa o presenter
     */
    private val presenter: HomeContract.UserActionsListener<HomeContract.UserView> by lazy {
        HomePresenter(this, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarViews()
    }

    private fun iniciarViews() {

        recycler_books.layoutManager = LinearLayoutManager(this)
        adapter = BooksAdapter(ArrayList<Book>(),this)
        recycler_books.adapter = adapter

    }


    override fun showBooks(books: List<Book>) {
        adapter?.replaceData(books)
    }

    /**
     * Função chamada pelo presenter para exibir ou ocultar progressBar
     */
    override fun showProgressbar(show: Boolean) {
        if (show){
            progress.visibility = View.VISIBLE
        }else{
            progress.visibility = View.INVISIBLE
        }

    }

    override fun onResume() {
        presenter.loadBooks()
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        //Ao destruir a activity desativamos o presenter
        presenter.onDestroy()
    }
}

