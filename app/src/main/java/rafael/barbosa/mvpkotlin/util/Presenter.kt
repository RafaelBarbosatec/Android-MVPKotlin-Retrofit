package rafael.barbosa.mvpkotlin.util

/**
 * Created by dev on 07/07/17.
 */
interface Presenter<T : View> {
    var view: T?

    fun onDestroy(){
        view = null
    }
}