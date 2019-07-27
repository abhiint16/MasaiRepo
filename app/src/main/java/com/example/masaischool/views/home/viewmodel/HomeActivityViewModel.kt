package com.example.masaischool.views.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.masaischool.datamanager.DataManager

class HomeActivityViewModel : ViewModel {
    var dataManager: DataManager

    internal var mutableLiveData = MutableLiveData<Boolean>()

    constructor(dataManager: DataManager) : super() {
        this.dataManager = dataManager
    }

    fun getQuestionData() {
        dataManager.getQuestionData()
    }

    fun observeForLiveData(): LiveData<Boolean> {
        return mutableLiveData
    }
}