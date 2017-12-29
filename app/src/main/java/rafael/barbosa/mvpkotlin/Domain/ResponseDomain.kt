package rafael.barbosa.mvpkotlin.Domain

/**
 * Created by rafaelbarbosa on 27/12/17.
 */

interface ResponseDomain<T>{

    fun response(response:T?)

}