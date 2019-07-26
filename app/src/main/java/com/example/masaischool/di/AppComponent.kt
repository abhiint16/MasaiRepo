package com.example.masaischool.di

import android.app.Application
import com.example.masaischool.MasaiSchoolApp
import com.example.masaischool.di.builder.ViewBuilderProvider
import com.example.masaischool.di.modules.AppModule
import com.example.masaischool.di.modules.ContextModule
import com.example.masaischool.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, ContextModule::class, NetworkModule::class,
        AndroidInjectionModule::class, ViewBuilderProvider::class]
)
interface AppComponent {

    fun inject(masaiSchoolApp: MasaiSchoolApp)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}