package com.example.masaischool.datamanager.localjson

import android.content.Context

import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets

class JsonToString(internal var context: Context) {

    fun loadJSONFromAsset(): String? {
        var json: String? = null
        try {
            val `is` = context.assets.open("questionlist.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, StandardCharsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }
}
