package com.example.masaischool.views.home.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.HashMap

class QuestionListDataModel() : Parcelable {

    @SerializedName("question_id")
    var questionId: String? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("question_data")
    var questionData: String? = null
    @SerializedName("options_list")
    var optionList: List<OptionListModel> = ArrayList()

    var stringMap: MutableMap<String, String> = HashMap()

    constructor(parcel: Parcel) : this() {
        questionId = parcel.readString()
        title = parcel.readString()
        questionData = parcel.readString()
        optionList = parcel.createTypedArrayList(OptionListModel.CREATOR)!!
    }

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        parcel?.writeString(questionId)
        parcel?.writeString(title)
        parcel?.writeString(questionData)
        parcel?.writeTypedList(optionList)
    }

    override fun describeContents(): Int {
        return 0
    }


    companion object CREATOR : Parcelable.Creator<QuestionListDataModel> {
        override fun createFromParcel(parcel: Parcel): QuestionListDataModel {
            return QuestionListDataModel(parcel)
        }

        override fun newArray(size: Int): Array<QuestionListDataModel?> {
            return arrayOfNulls(size)
        }
    }

}