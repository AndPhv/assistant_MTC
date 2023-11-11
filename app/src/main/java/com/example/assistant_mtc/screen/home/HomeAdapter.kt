package com.example.assistant_mtc.screen.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assistant_mtc.R
import com.example.assistant_mtc.model.LessonPresentation

class HomeAdapter(
    private val homeOnClickListener: HomeOnClickListener
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var lessonList = arrayListOf<LessonPresentation>()

    interface HomeOnClickListener {
        fun onClick(command: Int)
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numLesTextView: TextView = itemView.findViewById(R.id.textViewNumLes)
        val timeLesTextView: TextView = itemView.findViewById(R.id.textViewTimeLes)
        val lessonTextView: TextView = itemView.findViewById(R.id.textViewLes)
        val employeeTextView: TextView = itemView.findViewById(R.id.textViewEmp)
        val audienceTextView: TextView = itemView.findViewById(R.id.textViewAud)
        val linearLayHome: LinearLayout = itemView.findViewById(R.id.linearLayHome)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val lesson = lessonList[position]
        holder.numLesTextView.text = lesson.id
        holder.lessonTextView.text = lesson.lesson
        holder.employeeTextView.text = lesson.employee
        holder.timeLesTextView.text = lesson.audience
        holder.audienceTextView.text = lesson.infoLesson
        holder.linearLayHome.setOnClickListener {
            homeOnClickListener.onClick(R.layout.fragment_lesson)
        }
    }

    override fun getItemCount(): Int {
        return lessonList.size
    }

    fun updateLessonList(inputArrayList: List<LessonPresentation>) {
        this.lessonList.clear()
        notifyItemChanged(1)
        this.lessonList.addAll(inputArrayList)
        notifyItemRangeChanged(0, inputArrayList.size)
    }
}