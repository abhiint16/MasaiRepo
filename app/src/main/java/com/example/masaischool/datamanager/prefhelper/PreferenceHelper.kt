package com.example.masaischool.datamanager.prefhelper

interface PreferenceHelper {
    fun removeSharedPreference()

    fun setName(name: String)

    fun getName(): String
}