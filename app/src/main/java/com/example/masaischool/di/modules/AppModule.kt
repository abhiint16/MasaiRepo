package com.example.masaischool.di.modules

import com.example.masaischool.AppConstants
import com.example.masaischool.datamanager.DataManager
import com.example.masaischool.datamanager.DataManagerImpl
import com.example.masaischool.datamanager.apihelper.ApiHelper
import com.example.masaischool.datamanager.apihelper.ApiHelperImpl
import com.example.masaischool.datamanager.apihelper.ApiService
import com.example.masaischool.datamanager.dbhelper.DBHelper
import com.example.masaischool.datamanager.dbhelper.DBHelperImpl
import com.example.masaischool.datamanager.prefhelper.PreferenceHelper
import com.example.masaischool.datamanager.prefhelper.PreferenceHelperImpl
import com.example.masaischool.di.qualifier.PreferenceName
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun providesDataManager(dataManagerImpl: DataManagerImpl):
            DataManager {
        return dataManagerImpl
    }

    @Provides
    @Singleton
    fun providesApiHelper(apiHelper: ApiHelperImpl):
            ApiHelper {
        return apiHelper
    }

    @Provides
    fun providesDBHelper(dbHelper: DBHelperImpl):
            DBHelper {
        return dbHelper
    }

    @Provides
    fun providesPrefHelper(preferenceHelper: PreferenceHelperImpl):
            PreferenceHelper {
        return preferenceHelper
    }

    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @PreferenceName
    fun providesSharedPrefName(): String {
        return AppConstants.SHARED_PREFERENCE_NAME;
    }
}