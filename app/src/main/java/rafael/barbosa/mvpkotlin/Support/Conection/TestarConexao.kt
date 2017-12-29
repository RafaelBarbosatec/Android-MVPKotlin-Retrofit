package com.prodeb.dev.app_caleola_kotlin.util_conection

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.support.v7.app.AlertDialog
import android.view.View


object TestarConexao {

    fun VerificaConexao(contexto: Context): Boolean {

        val cm = contexto.getSystemService(Activity.CONNECTIVITY_SERVICE) as ConnectivityManager//Pego a conectividade do contexto o qual o metodo foi chamado

        val netInfo = cm.activeNetworkInfo//Crio o objeto netInfo que recebe as informacoes da NEtwork

        return netInfo != null && netInfo.isConnectedOrConnecting && netInfo.isAvailable

    }
}
