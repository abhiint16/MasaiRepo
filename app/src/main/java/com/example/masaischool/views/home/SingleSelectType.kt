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
    internal var selectedItem: Map<String, String> = HashMap()

    internal var onClickListener: View.OnClickListener = OnClickListener { v ->
        val pos = v.getTag(R.id.position) as Int

        if (lastCheckedPos != pos) {
            val previousSelectedRadioButton =
                this@SingleSelectType.getChildAt(lastCheckedPos).findViewById<RadioButton>(R.id.radio_btn)
            previousSelectedRadioButton.isChecked = false
            (v as RadioButton).isChecked = true
        } else {
            (v as RadioButton).isChecked = true
        }
        lastCheckedPos = pos

        /*selectedItem.put(builder.itemData.getId(), builder.itemData.getDataMap().getOptions().get(pos));

            builder.itemData.getStringMap().clear();

            builder.itemData.getStringMap().put(builder.itemData.getId(), builder.itemData.getDataMap().getOptions().get(pos));*/

        builder.singleTypeOptionSelectedListener.onSingleSelected(selectedItem)

        invalidate()
    }

    constructor(context: Context) : super(context) {}

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
        internal var previousSelectedId = ""

        fun setOptionList(itemData: QuestionListDataModel): Builder {
            this.itemData = itemData
            return this
        }

        fun setListener(singleTypeOptionSelectedListener: SingleTypeOptionSelectedListener): Builder {
            this.singleTypeOptionSelectedListener = singleTypeOptionSelectedListener
            return this
        }

        fun setPreviousSelectedId(previousSelectedId: String): Builder {
            this.previousSelectedId = previousSelectedId
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
        if (builder.itemData == null) {
            return
        }

        this.orientation = LinearLayout.VERTICAL
        val noOfOption = builder.itemData!!.optionList.size

        for (pos in 0 until noOfOption) {
            val view = LayoutInflater.from(builder.context).inflate(R.layout.item_single_coice, this, false)

            val radioButton = view.findViewById<RadioButton>(R.id.radio_btn)
            radioButton.setTag(R.id.position, pos)
            radioButton.setOnClickListener(onClickListener)

            /*if (builder.previousSelectedId.substring(1, builder.previousSelectedId.length() - 1).equals(builder.itemData.getDataMap().getOptions().get(pos))) {
                radioButton.setChecked(true);
            }*/
            /*if (builder.itemData.getStringMap().containsKey(builder.itemData.getId())){}*/

            val textView = view.findViewById<TextView>(R.id.item_single_choice_text)
            textView.text = builder.itemData!!.optionList[pos].optionData

            this.addView(view, pos)
        }

    }

}
