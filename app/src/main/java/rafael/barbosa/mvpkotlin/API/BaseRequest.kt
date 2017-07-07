package com.prodeb.dev.app_caleola_kotlin.API

import com.google.gson.JsonArray

/**
 * Created by rafael on 23/03/17.
 */

class BaseRequest {

    var op: Boolean = false

    var msg: String? = null

    var data: JsonArray? = null

    override fun toString(): String {
        return "BaseRequest{" +
                "op=" + op +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}'
    }
}
