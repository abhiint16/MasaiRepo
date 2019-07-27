package com.example.masaischool.views.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.masaischool.datamanager.DataManager
import com.example.masaischool.views.home.model.OptionListModel
import com.example.masaischool.views.home.model.QuestionListModel
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class HomeActivityViewModel : ViewModel {
    var dataManager: DataManager

    var saveDataDBLiveData = MutableLiveData<Long>()

    var questionLiveData = MutableLiveData<QuestionListModel>()

    var optionClickCheckLiveData = MutableLiveData<Int>()

    constructor(dataManager: DataManager) : super() {
        this.dataManager = dataManager
    }

    fun getQuestionData() {
        dataManager.getQuestionData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { questionListModel ->
                questionLiveData.value = questionListModel
            }
    }

    fun getUserName(): String {
        return dataManager.getName()
    }

    fun submitTest(questionListModel: QuestionListModel) {
        dataManager.saveDataToDB(questionListModel, dataManager.getName())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
                saveDataDBLiveData.value = it
            })
    }

    fun setOptionClickLiveData() {
        optionClickCheckLiveData.value = optionClickCheckLiveData.value?.plus(1)
    }

    fun observeForQuestionLiveData(): LiveData<QuestionListModel> {
        return questionLiveData
    }

    fun observeForOptionClickLiveData(): LiveData<Int> {
        return optionClickCheckLiveData
    }

    fun observeForSaveSuccessLiveData(): LiveData<Long> {
        return saveDataDBLiveData
    }
}