package com.example.masaischool.datamanager.dbhelper

import com.example.masaischool.datamanager.dbhelper.database.MappedData
import com.example.masaischool.views.home.model.QuestionListModel
import io.reactivex.Single

interface DBHelper {

    fun saveDataToDB(questionListModel: QuestionListModel,name: String): Single<Long>

    fun getDataFromDB(): Single<List<MappedData>>

    fun getLatestDataFromDB(): Single<MappedData>
}