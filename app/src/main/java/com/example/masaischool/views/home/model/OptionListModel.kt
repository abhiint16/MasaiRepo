package com.example.masaischool.views.home.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class OptionListModel() : Parcelable {

    @SerializedName("option_id")
    var optionId: String? = null
    @SerializedName("option_data")
    var optionData: String? = null
    @SerializedName("is_answer")
    var isAnswer: Boolean? = false
    @SerializedName("is_selected")
    var isSelected: Boolean? = false

    constructor(parcel: Parcel) : this() {
        optionId = parcel.readString()
        optionData = parcel.readString()
        isAnswer = parcel.readByte() != 0.toByte()
        isSelected = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        parcel?.writeString(optionData)
        parcel?.writeString(optionId)
        parcel?.writeByte(if (isAnswer!!) 1 else 0)
        parcel?.writeByte(if (isSelected!!) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OptionListModel> {
        override fun createFromParcel(parcel: Parcel): OptionListModel {
            return OptionListModel(parcel)
        }

        override fun newArray(size: Int): Array<OptionListModel?> {
            return arrayOfNulls(size)
        }
    }
}