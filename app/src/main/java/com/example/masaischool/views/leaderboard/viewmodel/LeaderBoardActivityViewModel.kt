package com.example.masaischool.views.leaderboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.masaischool.datamanager.DataManager
import com.example.masaischool.datamanager.dbhelper.database.MappedData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class LeaderBoardActivityViewModel : ViewModel {
    var dataManager: DataManager

    internal var mutableLiveData = MutableLiveData<List<MappedData>>()

    constructor(dataManager: DataManager) : super() {
        this.dataManager = dataManager
    }

    fun getLeaderList() {
        dataManager.getDataFromDB()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
                mutableLiveData.value = it
            })
    }

    fun observeForLiveData(): LiveData<List<MappedData>> {
        return mutableLiveData
    }
}