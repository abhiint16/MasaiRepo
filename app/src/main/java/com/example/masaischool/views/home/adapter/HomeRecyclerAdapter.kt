package com.example.masaischool.views.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.masaischool.R
import com.example.masaischool.databinding.ItemQuestionBinding
import com.example.masaischool.views.home.SingleSelectType
import com.example.masaischool.views.home.SingleTypeOptionSelectedListener
import com.example.masaischool.views.home.model.QuestionListDataModel

class HomeRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var questionListDataModelList = ArrayList<QuestionListDataModel>()

    fun addData(questionListDataModelList: ArrayList<QuestionListDataModel>) {
        this.questionListDataModelList = questionListDataModelList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemQuestionBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_question,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).binding.optionsLayout.removeAllViews()
        val singleSelectAnswersTypeOptions = SingleSelectType.Builder()
            .setContext(holder.binding.root.context)
            .setPreviousSelectedId("")
            .setOptionList(questionListDataModelList.get(position))
            .setListener(onClickListener)
            .buildOption()

        holder.binding.optionsLayout.addView(singleSelectAnswersTypeOptions)

        val questionListDataModel = questionListDataModelList.get(position)
        holder.bind(questionListDataModel)
    }

    override fun getItemCount(): Int {
        if (questionListDataModelList == null || questionListDataModelList.size == 0)
            return 0
        else
            return questionListDataModelList.size
    }

    class ViewHolder : RecyclerView.ViewHolder {
        var binding: ItemQuestionBinding

        constructor(itemView: ItemQuestionBinding) : super(itemView.getRoot()) {
            this.binding = itemView
        }

        fun bind(questionListDataModel: QuestionListDataModel) {
            binding.item = questionListDataModel
        }
    }

    internal var onClickListener: SingleTypeOptionSelectedListener = object : SingleTypeOptionSelectedListener {
        override fun onSingleSelected(selectedItem: Map<String, String>) {

        }

    }

}