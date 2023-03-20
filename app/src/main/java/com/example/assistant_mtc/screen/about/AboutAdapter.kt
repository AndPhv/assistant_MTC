package com.example.assistant_mtc.screen.about

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assistant_mtc.R
import com.sogya.mtc.domain.models.AboutDomain

class AboutAdapter : RecyclerView.Adapter<AboutAdapter.AboutViewHolder>() {

    private var aboutList = arrayListOf<AboutDomain>()

    class AboutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headerTextView: TextView = itemView.findViewById(R.id.textViewHeader)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.about_item, parent, false)
        return AboutViewHolder(view)
    }

    override fun onBindViewHolder(holder: AboutViewHolder, position: Int) {
        val about = aboutList[position]
        holder.headerTextView.text = about.header
        holder.textView.text = about.text
    }

    override fun getItemCount(): Int {
        return aboutList.size
    }

    fun updateAboutList(inputArrayList: List<AboutDomain>) {
        this.aboutList.clear()
        notifyItemChanged(1)
        this.aboutList.addAll(inputArrayList)
        notifyItemRangeChanged(0, inputArrayList.size)
    }
}