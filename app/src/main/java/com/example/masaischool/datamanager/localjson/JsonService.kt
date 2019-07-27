package com.example.masaischool.datamanager.localjson


import com.example.masaischool.views.home.model.OptionListModel
import com.example.masaischool.views.home.model.QuestionListDataModel
import com.example.masaischool.views.home.model.QuestionListModel
import com.google.gson.Gson
import com.google.gson.JsonArray
import io.reactivex.Observable
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList

class JsonService(private val jsonToString: JsonToString) {

    fun getQuestionData(): Observable<QuestionListModel>? {

        val jsonString = jsonToString.loadJSONFromAsset()
        val questionListModel = QuestionListModel()

        try {
            val jsonObject = JSONObject(jsonString!!)
            val questionList = jsonObject.getJSONArray("question_list")

            val questionListData = ArrayList<QuestionListDataModel>()

            for (pos in 0 until questionList.length()) {
                val questionListDataModel = QuestionListDataModel()

                val item = questionList.getJSONObject(pos)

                val questionId = item.getString("question_id")
                val title = item.getString("title")
                val questionData = item.getString("question_data")

                questionListDataModel.questionId = questionId
                questionListDataModel.title = title
                questionListDataModel.questionData = questionData

                val optionsList = item.getJSONArray("options_list")

                val optionList = ArrayList<OptionListModel>()

                for (optionListPos in 0 until optionsList.length()) {
                    val optionListModel = OptionListModel()

                    val optionItem = optionsList.getJSONObject(optionListPos)

                    val optionId = optionItem.getString("option_id")
                    val optionData = optionItem.getString("option_data")
                    val isAnswer = optionItem.getBoolean("is_answer")

                    optionListModel.optionId = optionId
                    optionListModel.optionData = optionData
                    optionListModel.isAnswer = isAnswer
                    optionList.add(optionListModel)
                }

                questionListDataModel.optionList = optionList
                questionListData.add(questionListDataModel)

            }
            questionListModel.questionList = questionListData
            return Observable.just(questionListModel)

        } catch (e: JSONException) {
            e.printStackTrace()
            return null
        }

    }
}
