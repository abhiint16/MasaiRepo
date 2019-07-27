package com.example.masaischool.views.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HomeRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }

    public class CommentViewHolder : RecyclerView.ViewHolder {
        lateinit var binding: ItemBinding

        constructor(itemView: ItemBinding) : super(itemView.getRoot()) {
            this.binding = itemView
        }
    }

}