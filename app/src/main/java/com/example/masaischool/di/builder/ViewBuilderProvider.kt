package com.example.masaischool.di.builder

import com.example.masaischool.views.home.HomeActivity
import com.example.masaischool.views.home.di.HomeActivityModule
import com.example.masaischool.views.leaderboard.LeaderBoardActivity
import com.example.masaischool.views.leaderboard.di.LeaderBoardActivityModule
import com.example.masaischool.views.score.ScoreActivity
import com.example.masaischool.views.score.di.ScoreActivityModule
import com.example.masaischool.views.userdetail.UserDetailActivity
import com.example.masaischool.views.userdetail.di.UserDetailActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewBuilderProvider {

    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun homeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [UserDetailActivityModule::class])
    abstract fun userDetailActivity(): UserDetailActivity

    @ContributesAndroidInjector(modules = [ScoreActivityModule::class])
    abstract fun scoreActivity(): ScoreActivity

    @ContributesAndroidInjector(modules = [LeaderBoardActivityModule::class])
    abstract fun leaderBoardActivity(): LeaderBoardActivity
}