package rafael.barbosa.mvpkotlin.Support.Base

import android.content.Context
import android.support.v7.app.AppCompatActivity

/**
 * Created by rafaelbarbosa on 26/12/17.
 */

open class BaseActivity : AppCompatActivity(){

    protected val context: Context get() = this

}