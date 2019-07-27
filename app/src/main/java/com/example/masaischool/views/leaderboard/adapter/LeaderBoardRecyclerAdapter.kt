package com.example.masaischool.views.leaderboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.masaischool.R
import com.example.masaischool.databinding.ItemLeaderboardBinding
import com.example.masaischool.datamanager.dbhelper.database.MappedData

class LeaderBoardRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mappedDataList = ArrayList<MappedData>()

    fun addData(mappedDataList: ArrayList<MappedData>) {
        this.mappedDataList = mappedDataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemLeaderboardBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_leaderboard,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mappedData = mappedDataList.get(position)
        (holder as ViewHolder).bind(mappedData)
    }

    override fun getItemCount(): Int {
        if (mappedDataList.size == 0)
            return 0
        else
            return mappedDataList.size
    }

    class ViewHolder : RecyclerView.ViewHolder {
        var binding: ItemLeaderboardBinding

        constructor(itemView: ItemLeaderboardBinding) : super(itemView.getRoot()) {
            this.binding = itemView
        }

        fun bind(mappedData: MappedData) {
            binding.item = mappedData
        }
    }

}