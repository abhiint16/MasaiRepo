package com.example.masaischool.datamanager.localjson


import com.example.masaischool.views.home.model.QuestionListModel
import io.reactivex.Observable
import javax.inject.Inject

class LocalJsonHelperImpl : LocalJsonHelper {

    var jsonService: JsonService

    @Inject
    constructor(jsonService: JsonService) {
        this.jsonService = jsonService
    }

    override fun getQuestionData(): Observable<QuestionListModel> {
        return jsonService.getQuestionData()!!
    }

}
