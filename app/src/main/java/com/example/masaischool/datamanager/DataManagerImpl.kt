package com.example.masaischool.datamanager

import com.example.masaischool.datamanager.apihelper.ApiHelper
import com.example.masaischool.datamanager.dbhelper.DBHelper
import com.example.masaischool.datamanager.prefhelper.PreferenceHelper
import javax.inject.Inject

class DataManagerImpl : DataManager {
    var apiHelper: ApiHelper
    var dbHelper: DBHelper
    var preferenceHelper: PreferenceHelper

    @Inject
    constructor(apiHelper: ApiHelper, dbHelper: DBHelper, preferenceHelper: PreferenceHelper) {
        this.apiHelper = apiHelper
        this.dbHelper = dbHelper
        this.preferenceHelper = preferenceHelper
    }
}