package com.example.masaischool.views.leaderboard.di

import androidx.lifecycle.ViewModelProvider
import com.example.masaischool.datamanager.DataManager
import com.example.masaischool.utils.ViewModelProviderFactory
import com.example.masaischool.views.home.viewmodel.HomeActivityViewModel
import com.example.masaischool.views.leaderboard.viewmodel.LeaderBoardActivityViewModel
import com.example.masaischool.views.score.viewmodel.ScoreActivityViewModel
import com.example.masaischool.views.userdetail.viewmodel.UserDetailActivityViewModel
import dagger.Module
import dagger.Provides

@Module
class LeaderBoardActivityModule {

    @Provides
    fun providesLeaderBoardActivityViewModel(dataManager: DataManager): LeaderBoardActivityViewModel {
        return LeaderBoardActivityViewModel(dataManager)
    }

    @Provides
    fun providesViewModelProvider(leaderBoardActivityViewModel: LeaderBoardActivityViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(leaderBoardActivityViewModel)
    }
}