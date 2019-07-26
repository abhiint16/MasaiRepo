package com.example.masaischool.di.builder

import com.example.masaischool.views.home.HomeActivity
import com.example.masaischool.views.home.di.HomeActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewBuilderProvider {

    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun homeActivity(): HomeActivity
}