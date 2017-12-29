package rafael.barbosa.mvpkotlin.Ui.Home

import rafael.barbosa.mvpkotlin.Model.Book
import rafael.barbosa.mvpkotlin.Support.Base.Presenter
import rafael.barbosa.mvpkotlin.Support.Base.View

/**
 * Created by dev on 07/07/17.
 */
interface HomeContract{

    interface UserView: View {

        fun showProgressbar(show: Boolean)
        fun showBooks(books:List<Book>)
        fun showEmpty(show: Boolean)

    }

    interface UserActionsListener <T : View>: Presenter<T> {

        fun loadBooks()

    }

}