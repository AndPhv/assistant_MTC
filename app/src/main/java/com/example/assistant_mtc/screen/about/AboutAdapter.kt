package com.example.assistant_mtc.screen.about

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assistant_mtc.R
import com.sogya.mtc.domain.models.AboutDomain
import com.sogya.mtc.domain.models.AboutFutureDomain
import com.sogya.mtc.domain.utils.Constants

class AboutAdapter(
    private val aboutOnClickListener: AboutOnClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var aboutList = arrayListOf<Any>()

    interface AboutOnClickListener {
        fun onClick(command: String)
    }

    companion object {
        private const val IS_TEXT = 0
        private const val IS_FUTURE = 1
    }

    class AboutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headerTextView: TextView = itemView.findViewById(R.id.textViewHeader)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun getItemViewType(position: Int): Int {
        return when (aboutList[position]) {
            is AboutDomain -> IS_TEXT
            is AboutFutureDomain -> IS_FUTURE
            else -> -1
        }
    }

    class AboutFutureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mailAddressTextView: TextView = itemView.findViewById(R.id.textViewMailAddress)
        val addressTextView: TextView = itemView.findViewById(R.id.textViewAddress)
        val dutyNumberTextView: TextView = itemView.findViewById(R.id.textViewDutyNumber)
        val studyNumberTextView: TextView = itemView.findViewById(R.id.textViewStudyNumber)
        val emailTextView: TextView = itemView.findViewById(R.id.textViewAboutEmail)
        val telegramNewsTextView: TextView = itemView.findViewById(R.id.textViewTelegramNews)
        val telegramBotTextView: TextView = itemView.findViewById(R.id.textViewTelegramBot)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return when (viewType) {
            IS_FUTURE -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.about_future_item, parent, false)
                AboutFutureViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.about_item, parent, false)
                AboutViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val about = aboutList[position]
        when (holder) {
            is AboutFutureViewHolder -> {
                holder.apply {
                    if (about is AboutFutureDomain) {
                        mailAddressTextView.text = about.mailAddress
                        addressTextView.text = about.address
                        dutyNumberTextView.text = about.dutyNumber
                        studyNumberTextView.text = about.studyNumber
                        emailTextView.text = about.email
                        telegramNewsTextView.text = about.telegramNews
                        telegramBotTextView.text = about.telegramBot
                    }
                    telegramNewsTextView.setOnClickListener {
                        aboutOnClickListener.onClick(Constants.OPEN_TG_NEWS)
                    }
                    telegramBotTextView.setOnClickListener {
                        aboutOnClickListener.onClick(Constants.OPEN_TG_BOT)
                    }
                    addressTextView.setOnClickListener {
                        aboutOnClickListener.onClick(Constants.OPEN_ADDRESS)
                    }
                }
            }
            is AboutViewHolder -> {
                if (about is AboutDomain) {
                    holder.headerTextView.text = about.header
                    holder.textView.text = about.text
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return aboutList.size
    }

    fun updateAboutList(inputArrayList: List<Any>) {
        this.aboutList.clear()
        notifyItemChanged(1)
        this.aboutList.addAll(inputArrayList)
        notifyItemRangeChanged(0, inputArrayList.size)
    }
}