package com.example.masaischool.datamanager.dbhelper.database

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.masaischool.datamanager.dbhelper.DatabaseConstants
import io.reactivex.Single

@Dao
abstract class MasaiDao {

    /*@get:Query("SELECT * FROM " + DatabaseConstants.DatabaseTables.TABLE_NAME)
    val getAll: Single<List<MappedData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(data: MappedData): Long?*/

    /*@Query("DELETE FROM " + AppValues.Constants.SAVED_TABLE + " WHERE " + AppValues.Constants.ID + "=:id ")
    int removeDataById(String id);*/

    /*@Query("SELECT * FROM " + AppValues.Constants.SAVED_TABLE + " WHERE " + AppValues.Constants.ID + "=:id ")
    Single<String> getDataWithId(String id);*/

    @Insert
    abstract fun insertRow(mappedData: MappedData): Long

    /*SELECT name, rollno, score
    , rank() over (order by score, dob desc) as rnk
    FROM score
    WHERE examid = '1'
    ORDER BY score DESC, dob ASC*/

    /*@Query(" SELECT * FROM " + DatabaseConstants.DatabaseTables.TABLE_NAME + " ORDER BY " +
            DatabaseConstants.ColumnName.MARKS + " DESC ")
    abstract fun getAll(): Single<List<MappedData>>*/

    @RawQuery
    abstract fun getAll(query : SupportSQLiteQuery): Single<List<MappedData>>

    @Query(
        " SELECT * FROM " + DatabaseConstants.DatabaseTables.TABLE_NAME + " ORDER BY " +
                DatabaseConstants.ColumnName.ID + " DESC LIMIT 1 "
    )
    abstract fun getLatest(): Single<MappedData>

    /*@Query("delete from monitor_students_table")
    protected abstract fun deleteAll()*/

}