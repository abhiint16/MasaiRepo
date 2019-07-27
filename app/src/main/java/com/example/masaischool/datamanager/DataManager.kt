package com.example.masaischool.datamanager

import com.example.masaischool.datamanager.apihelper.ApiHelper
import com.example.masaischool.datamanager.dbhelper.DBHelper
import com.example.masaischool.datamanager.localjson.LocalJsonHelper
import com.example.masaischool.datamanager.prefhelper.PreferenceHelper

interface DataManager : ApiHelper, DBHelper, PreferenceHelper, LocalJsonHelper {
}