package com.example.masaischool.views.home

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import com.example.masaischool.R
import com.example.masaischool.views.home.model.OptionListModel
import com.example.masaischool.views.home.model.QuestionListDataModel

import java.util.HashMap

class SingleSelectType : LinearLayout {

    lateinit var builder: Builder
    internal var lastCheckedPos: Int = 0

    constructor(context: Context) : super(context)

    constructor(builder: Builder) : super(builder.context) {
        this.builder = builder
        addOptions(builder)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    class Builder {

        lateinit var itemData: QuestionListDataModel
        lateinit var singleTypeOptionSelectedListener: SingleTypeOptionSelectedListener
        lateinit var context: Context

        fun setOptionList(itemData: QuestionListDataModel): Builder {
            this.itemData = itemData
            return this
        }

        fun setListener(singleTypeOptionSelectedListener: SingleTypeOptionSelectedListener): Builder {
            this.singleTypeOptionSelectedListener = singleTypeOptionSelectedListener
            return this
        }

        fun setContext(context: Context): Builder {
            this.context = context
            return this
        }

        fun buildOption(): SingleSelectType {
            return SingleSelectType(this)
        }

    }


    fun addOptions(builder: Builder) {

        this.orientation = LinearLayout.VERTICAL
        val noOfOption = builder.itemData.optionList.size

        for (pos in 0 until noOfOption) {
            val view = LayoutInflater.from(builder.context).inflate(R.layout.item_single_coice, this, false)

            val radioButton = view.findViewById<RadioButton>(R.id.radio_btn)
            radioButton.setTag(R.id.position, pos)
            radioButton.setOnClickListener(onClickListener)

            if (builder.itemData.optionList.get(pos).isSelected!!) {
                radioButton.setChecked(true);
            }

            val textView = view.findViewById<TextView>(R.id.item_single_choice_text)
            textView.text = builder.itemData.optionList[pos].optionData

            this.addView(view, pos)
        }

    }


    internal var onClickListener: View.OnClickListener = OnClickListener { v ->
        val pos = v.getTag(R.id.position) as Int

        for ((index, item) in builder.itemData.optionList.withIndex()) {
            if (index == pos) {
                builder.itemData.optionList.get(index).isSelected = true
                (v as RadioButton).isChecked = true
            } else {
                val previousSelectedRadioButton =
                    this@SingleSelectType.getChildAt(index).findViewById<RadioButton>(R.id.radio_btn)
                builder.itemData.optionList.get(index).isSelected = false
                previousSelectedRadioButton.isChecked = false
            }
        }

        lastCheckedPos = pos



        builder.singleTypeOptionSelectedListener.onSingleSelected()

        invalidate()
    }

}
