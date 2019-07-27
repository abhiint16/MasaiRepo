package com.example.masaischool.views.leaderboard

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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.masaischool.R
import com.example.masaischool.databinding.ActivityHomeBinding
import com.example.masaischool.databinding.ActivityLeaderboardBinding
import com.example.masaischool.databinding.ActivityScoreBinding
import com.example.masaischool.databinding.ActivityUserdetailBinding
import com.example.masaischool.datamanager.dbhelper.database.MappedData
import com.example.masaischool.views.home.HomeActivity
import com.example.masaischool.views.leaderboard.adapter.LeaderBoardRecyclerAdapter
import com.example.masaischool.views.leaderboard.viewmodel.LeaderBoardActivityViewModel
import com.example.masaischool.views.score.viewmodel.ScoreActivityViewModel
import com.example.masaischool.views.userdetail.viewmodel.UserDetailActivityViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class LeaderBoardActivity : AppCompatActivity(), View.OnClickListener {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    lateinit var leaderBoardActivityViewModel: LeaderBoardActivityViewModel

    lateinit var binding: ActivityLeaderboardBinding

    lateinit var leaderBoardRecyclerAdapter: LeaderBoardRecyclerAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDagger()
        initBinding()
        initRecyclerView()
        initViewModel()
        initObserver()
        setUp()
    }

    private fun initViewModel() {
        leaderBoardActivityViewModel =
            ViewModelProviders.of(this, factory).get(LeaderBoardActivityViewModel::class.java)
    }

    private fun initRecyclerView() {
        leaderBoardRecyclerAdapter = LeaderBoardRecyclerAdapter()
        linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerview.setLayoutManager(linearLayoutManager)
        binding.recyclerview.setAdapter(leaderBoardRecyclerAdapter)
    }


    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_leaderboard)
    }

    private fun initDagger() {
        AndroidInjection.inject(this)
    }

    private fun setUp() {
        leaderBoardActivityViewModel.getLeaderList()
    }

    private fun initObserver() {
        leaderBoardActivityViewModel.observeForLiveData().observe(this, Observer {
            leaderBoardRecyclerAdapter.addData(it as ArrayList<MappedData>)
        })
    }

    override fun onClick(p0: View?) {
        /*val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)*/
    }
}