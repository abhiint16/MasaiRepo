package com.example.masaischool.datamanager.prefhelper

import android.content.Context
import android.content.SharedPreferences
import com.example.masaischool.di.qualifier.PreferenceName
import javax.inject.Inject

class PreferenceHelperImpl : PreferenceHelper {
    var context: Context
    var prefName: String
    var sharedPreferences: SharedPreferences

    private val NAME = "name"

    @Inject
    constructor(context: Context, @PreferenceName prefName: String) {
        this.context = context
        this.prefName = prefName
        this.sharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    override fun removeSharedPreference() {
        sharedPreferences.edit().clear().apply()
    }

    override fun setName(name: String) {
        sharedPreferences.edit().putString(NAME, name).apply()
    }

    override fun getName(): String {
        return sharedPreferences.getString(NAME, "name")!!
    }
}