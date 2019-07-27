package com.example.masaischool.datamanager

import com.example.masaischool.datamanager.apihelper.ApiHelper
import com.example.masaischool.datamanager.dbhelper.DBHelper
import com.example.masaischool.datamanager.localjson.LocalJsonHelper
import com.example.masaischool.datamanager.prefhelper.PreferenceHelper
import com.example.masaischool.views.home.model.QuestionListModel
import io.reactivex.Observable
import javax.inject.Inject

class DataManagerImpl : DataManager {

    var apiHelper: ApiHelper
    var dbHelper: DBHelper
    var preferenceHelper: PreferenceHelper
    var localJsonHelper: LocalJsonHelper

    @Inject
    constructor(
        apiHelper: ApiHelper, dbHelper: DBHelper, preferenceHelper: PreferenceHelper, localJsonHelper: LocalJsonHelper
    ) {
        this.localJsonHelper = localJsonHelper
        this.apiHelper = apiHelper
        this.dbHelper = dbHelper
        this.preferenceHelper = preferenceHelper
    }

    override fun getQuestionData(): Observable<QuestionListModel> {
        return localJsonHelper.getQuestionData()
    }
}