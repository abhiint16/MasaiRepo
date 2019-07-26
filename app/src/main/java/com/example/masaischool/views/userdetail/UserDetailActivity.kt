package com.example.masaischool.views.userdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.masaischool.R
import com.example.masaischool.databinding.ActivityUserdetailBinding
import com.example.masaischool.views.userdetail.viewmodel.UserDetailActivityViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class UserDetailActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    lateinit var homeActivityViewModel: UserDetailActivityViewModel

    lateinit var binding: ActivityUserdetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_userdetail)

        homeActivityViewModel = ViewModelProviders.of(this, factory).get(UserDetailActivityViewModel::class.java)

        homeActivityViewModel.testFun()

        initObserver()
    }

    private fun initObserver() {

    }
}