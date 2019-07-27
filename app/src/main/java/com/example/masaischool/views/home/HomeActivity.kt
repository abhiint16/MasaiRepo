package com.example.masaischool.views.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.masaischool.R
import com.example.masaischool.databinding.ActivityHomeBinding
import com.example.masaischool.views.home.adapter.HomeRecyclerAdapter
import com.example.masaischool.views.home.model.QuestionListDataModel
import com.example.masaischool.views.home.model.QuestionListModel
import com.example.masaischool.views.home.viewmodel.HomeActivityViewModel
import com.example.masaischool.views.score.ScoreActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    lateinit var homeActivityViewModel: HomeActivityViewModel

    lateinit var binding: ActivityHomeBinding

    lateinit var mainRecyclerAdapter: HomeRecyclerAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    lateinit var questionListModel: QuestionListModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDagger()
        initViewModel()
        initDataBinding()
        initRecyclerView()
        initObserver()
        setUp()

        homeActivityViewModel.getQuestionData()

    }

    private fun setUp() {
        supportActionBar?.setTitle(homeActivityViewModel.getUserName())
        binding.submitTestBtn.setOnClickListener(this)
    }

    private fun initRecyclerView() {
        mainRecyclerAdapter = HomeRecyclerAdapter()
        linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerview.setLayoutManager(linearLayoutManager)
        binding.recyclerview.setAdapter(mainRecyclerAdapter)
        mainRecyclerAdapter.setViewModel(homeActivityViewModel)
    }

    private fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.viewmodel = homeActivityViewModel
    }

    private fun initViewModel() {
        homeActivityViewModel = ViewModelProviders.of(this, factory).get(HomeActivityViewModel::class.java)
    }

    private fun initDagger() {
        AndroidInjection.inject(this)
    }

    private fun initObserver() {
        homeActivityViewModel.observeForQuestionLiveData().observe(this, Observer { questionData ->
            mainRecyclerAdapter.addData(questionData.questionList as ArrayList<QuestionListDataModel>)
            questionListModel = questionData
        })

        homeActivityViewModel.observeForOptionClickLiveData().observe(this, Observer { noOfOptionSelected ->

        })

        homeActivityViewModel.observeForSaveSuccessLiveData().observe(this, Observer { noOfOptionSelected ->
            val intent = Intent(this, ScoreActivity::class.java)
            startActivity(intent)
        })
    }

    override fun onClick(p0: View?) {
        homeActivityViewModel.submitTest(questionListModel)
    }
}