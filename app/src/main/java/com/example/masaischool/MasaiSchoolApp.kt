package com.example.masaischool

import android.app.Activity
import android.app.Application
import com.example.masaischool.di.AppComponent
import com.example.masaischool.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MasaiSchoolApp : Application(), HasActivityInjector {

    @set:Inject
    internal var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    internal var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder().application(this)
            .build()
        appComponent!!.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

}