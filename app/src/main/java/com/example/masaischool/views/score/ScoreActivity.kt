package com.example.masaischool.views.score

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.masaischool.R
import com.example.masaischool.databinding.ActivityScoreBinding
import com.example.masaischool.databinding.ActivityUserdetailBinding
import com.example.masaischool.views.home.HomeActivity
import com.example.masaischool.views.leaderboard.LeaderBoardActivity
import com.example.masaischool.views.score.viewmodel.ScoreActivityViewModel
import com.example.masaischool.views.userdetail.viewmodel.UserDetailActivityViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class ScoreActivity : AppCompatActivity(), View.OnClickListener {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    lateinit var scoreActivityViewModel: ScoreActivityViewModel

    lateinit var binding: ActivityScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDagger()
        initBinding()
        initViewModel()
        initObserver()
        setUp()
        scoreActivityViewModel.getUserScore()
    }

    private fun initViewModel() {
        scoreActivityViewModel = ViewModelProviders.of(this, factory).get(ScoreActivityViewModel::class.java)
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_score)
    }

    private fun initDagger() {
        AndroidInjection.inject(this)
    }

    private fun setUp() {
        binding.proceedToLeaderBoard.setOnClickListener(this)
    }

    private fun initObserver() {
        scoreActivityViewModel.observeForLiveData().observe(this, Observer {
            binding.score.setText("Hey! " + it.name + " Your Score is " + it.marks.toString())
        })
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this, LeaderBoardActivity::class.java)
        startActivity(intent)
    }
}