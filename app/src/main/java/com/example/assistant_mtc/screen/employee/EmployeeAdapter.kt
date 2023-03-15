package com.example.assistant_mtc.screen.employee

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assistant_mtc.databinding.EmployeeItemBinding
//import kotlinx.android.synthetic.main.employee_item.view.*

class EmployeeAdapter: RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder>() {

    private var employeeList = emptyList<com.sogya.mtc.domain.models.Employee>()

    inner class EmployeeHolder(val binding: EmployeeItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeHolder {
        return EmployeeHolder(EmployeeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: EmployeeHolder, position: Int) {
        holder.binding.tvFullName.text = employeeList[position].fullName
        holder.binding.tvTitleJob.text = employeeList[position].jobTitle
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    fun setList(list: List<com.sogya.mtc.domain.models.Employee>) {
        employeeList = list
        notifyDataSetChanged()
    }
}