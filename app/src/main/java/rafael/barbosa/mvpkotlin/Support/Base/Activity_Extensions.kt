package rafael.barbosa.mvpkotlin.Support.Base

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View

/**
 * Created by rafaelbarbosa on 26/12/17.
 */

fun AppCompatActivity.onClick(@IdRes viewId: Int, onClick: (v: android.view.View?) -> Unit){
    val view = findViewById<View>(viewId)
    view.setOnClickListener { onClick(it) }
}

fun AppCompatActivity.setupToolbar(@IdRes viewId: Int, title: String? = null,
                                   upNavigation: Boolean = false): ActionBar {

    val toolbar = findViewById<Toolbar>(viewId)
    setSupportActionBar(toolbar)
    if (title != null){
        supportActionBar?.title = title
    }

    supportActionBar?.setDisplayHomeAsUpEnabled(upNavigation)

    return supportActionBar!!

}

fun AppCompatActivity.addFrament(@IdRes layoutId: Int, fragment: Fragment){

    fragment.arguments = intent.extras
    val ft = supportFragmentManager.beginTransaction()
    ft.add(layoutId,fragment)
    ft.commit()

}