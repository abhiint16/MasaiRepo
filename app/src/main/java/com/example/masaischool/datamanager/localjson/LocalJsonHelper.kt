package com.example.masaischool.datamanager.localjson

import com.example.masaischool.views.home.model.QuestionListModel
import io.reactivex.Observable


interface LocalJsonHelper {

    fun getQuestionData(): Observable<QuestionListModel>
}
