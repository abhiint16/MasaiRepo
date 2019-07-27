package com.example.masaischool.views.userdetail

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.masaischool.R
import com.example.masaischool.databinding.ActivityUserdetailBinding
import com.example.masaischool.views.home.HomeActivity
import com.example.masaischool.views.userdetail.viewmodel.UserDetailActivityViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class UserDetailActivity : AppCompatActivity(), View.OnClickListener {

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
        setUp()
    }

    private fun setUp() {
        binding.proceedBtn.setOnClickListener(this)
        binding.usernameEdittext.addTextChangedListener(usernameWatcher)
    }

    private fun initObserver() {

    }

    var usernameWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            //do nothing
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            //do nothing
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            if (binding.usernameLayout.isErrorEnabled) {
                binding.usernameLayout.setErrorEnabled(false)
            }
        }

    }

    override fun onClick(p0: View?) {
        val username = binding.usernameEdittext.text.toString()

        if (username.isEmpty()) {
            binding.usernameLayout.error = getString(R.string.username_error)
        } else {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}