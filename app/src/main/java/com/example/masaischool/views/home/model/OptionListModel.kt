package com.example.masaischool.views.home.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class OptionListModel() : Parcelable {

    @SerializedName("option_id")
    var optionId: String? = null
    @SerializedName("option_data")
    var optionData: String? = null

    constructor(parcel: Parcel) : this() {
        optionId = parcel.readString()
        optionData = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        parcel?.writeString(optionData)
        parcel?.writeString(optionId)
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