package rafael.barbosa.mvpkotlin.Home

import android.app.Activity
import android.content.Context
import android.util.Log
import com.prodeb.dev.app_caleola_kotlin.API.BaseRequest
import com.prodeb.dev.app_caleola_kotlin.API.RetrofitConection
import com.prodeb.dev.app_caleola_kotlin.util_conection.TentarNovamente
import com.prodeb.dev.app_caleola_kotlin.util_conection.TestarConexao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by dev on 07/07/17.
 */
class HomePresenter(val context: Context?, override var view: HomeContract.UserView?): HomeContract.UserActionsListener<HomeContract.UserView>, TentarNovamente {


    /**
     * Função chamada pela view ao clicar no botão
     */
    override fun getData() {

        view?.showResponde("")

        /**
         * Testamos se existe conexão, se sim chamamos o servidor
         */
        if (TestarConexao.VerificaConexao(context as Activity,this,"log")) {
            view?.showProgressbar(true)
            RetrofitConection.instance.baseAPI.getUsuarios().enqueue(object : Callback<BaseRequest> {

                override fun onResponse(call: Call<BaseRequest>?, response: Response<BaseRequest>?) {
                    if (response != null) {
                        if (response.isSuccessful) {
                            view?.showResponde(response?.body()?.data.toString())
                        }
                    }
                    view?.showProgressbar(false)
                }

                override fun onFailure(call: Call<BaseRequest>?, t: Throwable?) {
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
        getData()
    }

}