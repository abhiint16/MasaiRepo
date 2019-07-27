package com.example.masaischool.views.score.di

import androidx.lifecycle.ViewModelProvider
import com.example.masaischool.datamanager.DataManager
import com.example.masaischool.utils.ViewModelProviderFactory
import com.example.masaischool.views.home.viewmodel.HomeActivityViewModel
import com.example.masaischool.views.score.viewmodel.ScoreActivityViewModel
import com.example.masaischool.views.userdetail.viewmodel.UserDetailActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class ScoreActivityModule {

    @Provides
    fun providesScoreActivityViewModel(dataManager: DataManager): ScoreActivityViewModel {
        return ScoreActivityViewModel(dataManager)
    }

    @Provides
    fun providesViewModelProvider(scoreActivityViewModel: ScoreActivityViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(scoreActivityViewModel)
    }
}