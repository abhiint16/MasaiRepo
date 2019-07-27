package com.example.masaischool.views.home.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class QuestionListModel() : Parcelable {

    @SerializedName("question_list")
    var questionList: List<QuestionListDataModel> = ArrayList()

    constructor(parcel: Parcel) : this() {
        questionList = parcel.createTypedArrayList(QuestionListDataModel.CREATOR)!!
    }

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        parcel?.writeTypedList(questionList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionListModel> {
        override fun createFromParcel(parcel: Parcel): QuestionListModel {
            return QuestionListModel(parcel)
        }

        override fun newArray(size: Int): Array<QuestionListModel?> {
            return arrayOfNulls(size)
        }
    }
}
