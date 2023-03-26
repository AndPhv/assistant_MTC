package com.example.assistant_mtc.screen.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assistant_mtc.R
import com.sogya.mtc.domain.models.LessonDomain

class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    private var lessonList = arrayListOf<LessonDomain>()

    class LessonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val audLesTextView: TextView = itemView.findViewById(R.id.textViewAudLes)
        val lessonLesTextView: TextView = itemView.findViewById(R.id.textViewLessonLes)
        val empLesTextView: TextView = itemView.findViewById(R.id.textViewEmpLes)
        val infoLesTextView: TextView = itemView.findViewById(R.id.textViewInfoLes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lesson_item, parent, false)
        return LessonViewHolder(view)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val lesson = lessonList[position]
        holder.audLesTextView.text = lesson.audience
        holder.lessonLesTextView.text = lesson.lesson
        holder.empLesTextView.text = lesson.employee
        holder.infoLesTextView.text = lesson.infoLesson
    }

    override fun getItemCount(): Int {
        return lessonList.size
    }

    fun updateLessonList(inputArrayList: List<LessonDomain>) {
        this.lessonList.clear()
        notifyItemChanged(1)
        this.lessonList.addAll(inputArrayList)
        notifyItemRangeChanged(0, inputArrayList.size)
    }




}