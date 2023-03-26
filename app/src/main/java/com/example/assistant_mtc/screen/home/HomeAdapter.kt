package com.example.assistant_mtc.screen.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assistant_mtc.R
import com.sogya.mtc.domain.models.HomeDomain

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var homeList = arrayListOf<HomeDomain>()

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numLesTextView: TextView = itemView.findViewById(R.id.textViewNumLes)
        val timeLesTextView: TextView = itemView.findViewById(R.id.textViewTimeLes)
        val lessonTextView: TextView = itemView.findViewById(R.id.textViewLes)
        val employeeTextView: TextView = itemView.findViewById(R.id.textViewEmp)
        val audienceTextView: TextView = itemView.findViewById(R.id.textViewAud)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val home = homeList[position]
        holder.numLesTextView.text = home.numLes
        holder.timeLesTextView.text = home.timeLes
        holder.lessonTextView.text = home.lesson
        holder.employeeTextView.text = home.employee
        holder.audienceTextView.text = home.audience
    }

    override fun getItemCount(): Int {
        return homeList.size
    }

    fun updateHomeList(inputArrayList: List<HomeDomain>) {
        this.homeList.clear()
        notifyItemChanged(1)
        this.homeList.addAll(inputArrayList)
        notifyItemRangeChanged(0, inputArrayList.size)
    }

}