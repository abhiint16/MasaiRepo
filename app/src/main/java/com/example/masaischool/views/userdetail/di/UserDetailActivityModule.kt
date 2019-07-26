package com.example.masaischool.views.userdetail.di

import androidx.lifecycle.ViewModelProvider
import com.example.masaischool.datamanager.DataManager
import com.example.masaischool.utils.ViewModelProviderFactory
import com.example.masaischool.views.home.viewmodel.HomeActivityViewModel
import com.example.masaischool.views.userdetail.viewmodel.UserDetailActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class UserDetailActivityModule {

    @Provides
    fun providesUserDetailActivityViewModel(dataManager: DataManager): UserDetailActivityViewModel {
        return UserDetailActivityViewModel(dataManager)
    }

    @Provides
    fun providesViewModelProvider(userDetailActivityViewModel: UserDetailActivityViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(userDetailActivityViewModel)
    }
}