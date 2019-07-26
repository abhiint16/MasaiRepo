package com.example.masaischool.di.builder

import com.example.masaischool.views.HomeActivity
import com.example.masaischool.views.di.HomeActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ViewBuilderProvider {

    @ContributesAndroidInjector(modules = [HomeActivityModule::class])
    abstract fun homeActivity(): HomeActivity
}