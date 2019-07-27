package com.example.masaischool.datamanager.dbhelper.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Transaction

import javax.inject.Singleton

@Database(entities = [MappedData::class], version = 2, exportSchema = false)
@Singleton
abstract class MasaiDatabase : RoomDatabase() {

    //Note : Add | Define All the tables here like

    abstract val masaiDao: MasaiDao

    @Transaction
    fun clearDatabase(): Boolean {

        val database = this

        try {
            database.clearAllTables()
            return true
        } catch (e: Exception) {
            return false
        } finally {
            database.endTransaction()
        }
    }

}