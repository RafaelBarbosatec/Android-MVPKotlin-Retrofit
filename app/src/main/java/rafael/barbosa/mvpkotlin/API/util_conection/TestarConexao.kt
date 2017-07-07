package com.prodeb.dev.app_caleola_kotlin.util_conection

import android.app.Activity
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AlertDialog
import android.view.View


object TestarConexao {

    fun VerificaConexao(contexto: Activity, t: TentarNovamente, tag: String): Boolean {

        val cm = contexto.getSystemService(Activity.CONNECTIVITY_SERVICE) as ConnectivityManager//Pego a conectividade do contexto o qual o metodo foi chamado

        val netInfo = cm.activeNetworkInfo//Crio o objeto netInfo que recebe as informacoes da NEtwork

        if (netInfo != null && netInfo.isConnectedOrConnecting && netInfo.isAvailable)
        //Se o objeto for nulo ou nao tem conectividade retorna false
            return true
        else {
            calldialog(contexto, t, tag)
            return false
        }

    }

    fun calldialog(c: Activity?, t: TentarNovamente, tag: String) {

        if (c != null) {

            val alertDialogBuilder = AlertDialog.Builder(c)
            alertDialogBuilder.setTitle("")
            alertDialogBuilder.setMessage("Ops, ocorreu algum erro na comunicação, verifique sua conexão e tente novamente.")
            alertDialogBuilder.setPositiveButton("TENTAR NOVAMENTE") { arg0, arg1 -> t.tentarNovamente(tag) }

            alertDialogBuilder.show()

        }
    }
}
