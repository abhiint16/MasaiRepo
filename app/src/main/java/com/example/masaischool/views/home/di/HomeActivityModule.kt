package com.example.masaischool.views.home.di

import androidx.lifecycle.ViewModelProvider
import com.example.masaischool.datamanager.DataManager
import com.example.masaischool.utils.ViewModelProviderFactory
import com.example.masaischool.views.home.viewmodel.HomeActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    fun providesHomeActivityViewModel(dataManager: DataManager): HomeActivityViewModel {
        return HomeActivityViewModel(dataManager)
    }

    @Provides
    fun providesViewModelProvider(homeActivityViewModel: HomeActivityViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(homeActivityViewModel)
    }
}