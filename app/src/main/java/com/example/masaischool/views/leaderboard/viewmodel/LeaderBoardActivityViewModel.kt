package com.example.masaischool.views.leaderboard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.masaischool.datamanager.DataManager
import com.example.masaischool.datamanager.dbhelper.database.MappedData
import io.reactivex.Single
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
                var mappedData: List<MappedData> = createRank(it)
                mutableLiveData.value = it
            })
    }

    fun createRank(mappedData: List<MappedData>): List<MappedData> {
        val mappedData: List<MappedData> = mappedData
        for ((index, item) in mappedData.withIndex()) {
            if (index == 0) {
                mappedData.get(index).rank = index + 1
            } else {
                if (mappedData.get(index).marks == mappedData.get(index - 1).marks) {
                    mappedData.get(index).rank = mappedData.get(index - 1).rank
                } else {
                    mappedData.get(index).rank = index + 1
                }
            }
        }
        return mappedData
    }

    fun observeForLiveData(): LiveData<List<MappedData>> {
        return mutableLiveData
    }
}