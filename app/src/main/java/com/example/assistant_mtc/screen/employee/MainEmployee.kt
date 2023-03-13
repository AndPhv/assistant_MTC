package com.example.assistant_mtc.screen.employee

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.assistant_mtc.databinding.ActivityMainBinding

class MainEmployee: AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: EmployeeAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initial()
    }

    private fun initial() {
        recyclerView = binding.rcView
        adapter = EmployeeAdapter()
        recyclerView.adapter = adapter
        adapter.setList(employee())
    }

    private fun employee() : ArrayList<Employee> {
        val employeeList = ArrayList<Employee>()

        val employee1 = Employee("Каргапольцев Аркадий Аркадьевич","111")
        employeeList.add(employee1)

        val employee2 = Employee("Ситников Виктор Валерьевич","222")
        employeeList.add(employee2)

        val employee3 = Employee("Непорожнев Денис Александрович","333")
        employeeList.add(employee3)

        val employee4 = Employee("Шубин Андрей Владимирович","444")
        employeeList.add(employee4)

        val employee5 = Employee("Белоус Сергей Ильич","555")
        employeeList.add(employee5)

        return employeeList
    }
}