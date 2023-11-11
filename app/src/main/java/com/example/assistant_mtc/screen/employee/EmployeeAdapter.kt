package com.example.assistant_mtc.screen.employee

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assistant_mtc.R
import com.sogya.mtc.domain.models.EmployeeDomain
import com.sogya.mtc.domain.models.EmployeeHeaderDomain

class EmployeeAdapter(
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var employeeList = arrayListOf<Any>()

    companion object {
        private const val IS_EMPLOYEE = 0
        private const val IS_HEADER = 1
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headerEmpTextView: TextView = itemView.findViewById(R.id.textViewHeaderEmp)
    }

    override fun getItemViewType(position: Int): Int {
        return when (employeeList[position]) {
            is EmployeeDomain -> IS_EMPLOYEE
            is EmployeeHeaderDomain -> IS_HEADER
            else -> -1
        }
    }

    //Вью холдер правильно создавать вот так
    class EmployeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageEmployee: ImageView = itemView.findViewById(R.id.imageViewEmployee)
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val jobTextView: TextView = itemView.findViewById(R.id.textViewJob)
        val emailTextView: TextView = itemView.findViewById(R.id.textViewEmail)
        val phoneTextView: TextView = itemView.findViewById(R.id.textViewPhone)
        val phoneAddTextView: TextView = itemView.findViewById(R.id.textViewPhoneAdd)
        val audienceTextView: TextView = itemView.findViewById(R.id.textViewAudience)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return when (viewType) {
            IS_HEADER -> {
                 view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.employee_header_item, parent, false)
                HeaderViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.employee_item, parent, false)
                EmployeeViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val employee = employeeList[position]
        when (holder) {
            is HeaderViewHolder -> {
                if (employee is EmployeeHeaderDomain) {
                    holder.headerEmpTextView.text = employee.header
                }
            }
            is EmployeeViewHolder -> {
                if (employee is EmployeeDomain) {
                    Glide
                        .with(context)
                        .load(employee.imageUri)
                        .centerCrop()
                        .placeholder(R.drawable.background)
                        .into(holder.imageEmployee)
                    holder.nameTextView.text = employee.fullName
                    holder.jobTextView.text = employee.jobTitle
                    holder.emailTextView.text = employee.email
                    holder.phoneTextView.text = employee.phone
                    holder.phoneAddTextView.text = employee.phoneAdd
                    holder.audienceTextView.text = employee.audience
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

    //Данные в адаптер поставляются через этот метод.
    //Сначала необходимо отчистить список, а потом уже вносить новые данные
    fun updateEmployeeList(inputArrayList: List<Any>) {
        this.employeeList.clear()
        notifyItemChanged(1)
        this.employeeList.addAll(inputArrayList)
        notifyItemRangeChanged(0, inputArrayList.size)
    }
}