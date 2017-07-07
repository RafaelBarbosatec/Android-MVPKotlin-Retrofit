package rafael.barbosa.mvpkotlin.Home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import rafael.barbosa.mvpkotlin.R

class HomeActivity : AppCompatActivity() , HomeContract.UserView{

    /**
     * Instanciamos de forma preguiçosa o presenter
     */
    private val presenter: HomeContract.UserActionsListener<HomeContract.UserView> by lazy {
        HomePresenter(this, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt.setOnClickListener { presenter.getData() }
    }

    /**
     * Função chamada pelo presenter para exibir resposta do servidor
     */
    override fun showResponde(response: String) {
       tv_result.text = response
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


    override fun onDestroy() {
        super.onDestroy()
        //Ao destruir a activity desativamos o presenter
        presenter.onDestroy()
    }
}
