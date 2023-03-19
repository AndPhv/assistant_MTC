package com.example.assistant_mtc.screen.employee

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assistant_mtc.R
import com.sogya.mtc.domain.models.EmployeeDomain

class EmployeeAdapter : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    private var employeeList = arrayListOf<EmployeeDomain>()

    //Вью холдер правильно создавать вот так
    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageEmployee: ImageView = itemView.findViewById(R.id.imageViewEmployee)
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val jobTextView: TextView = itemView.findViewById(R.id.textViewJob)
        val emailTextView: TextView = itemView.findViewById(R.id.textViewEmail)
        val phoneTextView: TextView = itemView.findViewById(R.id.textViewPhone)
        val audienceTextView: TextView = itemView.findViewById(R.id.textViewAudience)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.employee_item, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee = employeeList[position]
        holder.imageEmployee.setImageResource(employee.imageEmployee)
        holder.nameTextView.text = employee.fullName
        holder.jobTextView.text = employee.jobTitle
        holder.emailTextView.text = employee.email
        holder.phoneTextView.text = employee.phone
        holder.audienceTextView.text = employee.audience
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    //Данные в адаптер поставляются через этот метод.
    //Сначала необходимо отчистить список, а потом уже вносить новые данные
    fun updateEmployeeList(inputArrayList: List<EmployeeDomain>) {
        this.employeeList.clear()
        notifyItemChanged(1)
        this.employeeList.addAll(inputArrayList)
        notifyItemRangeChanged(0, inputArrayList.size)
    }
}