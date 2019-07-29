package com.example.masaischool.datamanager.dbhelper.database

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.masaischool.datamanager.dbhelper.DatabaseConstants
import io.reactivex.Single

@Dao
abstract class MasaiDao {

    @Insert
    abstract fun insertRow(mappedData: MappedData): Long

    @RawQuery
    abstract fun getAll(query : SupportSQLiteQuery): Single<List<MappedData>>

    @Query(
        " SELECT * FROM " + DatabaseConstants.DatabaseTables.TABLE_NAME + " ORDER BY " +
                DatabaseConstants.ColumnName.ID + " DESC LIMIT 1 "
    )
    abstract fun getLatest(): Single<MappedData>

}