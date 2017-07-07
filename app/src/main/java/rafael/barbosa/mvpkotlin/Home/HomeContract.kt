package rafael.barbosa.mvpkotlin.Home

import rafael.barbosa.mvpkotlin.util.Presenter
import rafael.barbosa.mvpkotlin.util.View

/**
 * Created by dev on 07/07/17.
 */
interface HomeContract{

    interface UserView: View {

        fun showProgressbar(show: Boolean)
        fun showResponde(response: String)

    }

    interface UserActionsListener <T : View>: Presenter<T> {

        fun getData()

    }

}