package com.example.masaischool.datamanager.dbhelper

import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.masaischool.datamanager.dbhelper.database.MappedData
import com.example.masaischool.datamanager.dbhelper.database.MasaiDatabase
import com.example.masaischool.views.home.model.QuestionListModel
import io.reactivex.Single
import javax.inject.Inject

class DBHelperImpl : DBHelper {

    var masaiDatabase: MasaiDatabase

    @Inject
    constructor(masaiDatabase: MasaiDatabase) {
        this.masaiDatabase = masaiDatabase
    }

    override fun saveDataToDB(questionListModel: QuestionListModel, name: String): Single<Long> {
        val mappedData = MappedData()
        var marks = 0

        for (item in questionListModel.questionList) {
            for (optionItem in item.optionList) {
                if (optionItem.isSelected!! && optionItem.isAnswer!!) {
                    marks++
                }
            }
        }

        mappedData.name = name
        mappedData.marks = marks
        return Single.fromCallable { masaiDatabase.masaiDao.insertRow(mappedData) }
    }

    override fun getDataFromDB(): Single<List<MappedData>> {
        var query: String =
            " SELECT * FROM " + DatabaseConstants.DatabaseTables.TABLE_NAME + " ORDER BY " +
                    DatabaseConstants.ColumnName.MARKS + " DESC "

        return masaiDatabase.masaiDao.getAll(SimpleSQLiteQuery(query))
    }

    override fun getLatestDataFromDB(): Single<MappedData> {
        return masaiDatabase.masaiDao.getLatest()
    }
}