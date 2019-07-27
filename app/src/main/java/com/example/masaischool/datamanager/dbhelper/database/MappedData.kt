package com.example.masaischool.datamanager.dbhelper.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.masaischool.datamanager.dbhelper.DatabaseConstants
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = DatabaseConstants.DatabaseTables.TABLE_NAME)
class MappedData {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DatabaseConstants.ColumnName.ID)
    @Expose
    @SerializedName("id")
    var id: Int? = null

    @ColumnInfo(name = DatabaseConstants.ColumnName.NAME)
    @Expose
    @SerializedName("name")
    var name: String? = null


    @ColumnInfo(name = DatabaseConstants.ColumnName.MARKS)
    @Expose
    @SerializedName("marks")
    var marks: Int? = null
}
