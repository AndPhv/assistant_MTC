package com.example.assistant_mtc.screen.employee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assistant_mtc.R
import com.example.assistant_mtc.databinding.FragmentEmployeeBinding

class EmployeeFragment : Fragment(R.layout.fragment_employee) {
    private lateinit var binding: FragmentEmployeeBinding
    private val vm: EmployeeVM by viewModels()
    private val employeeAdapter = EmployeeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmployeeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        //Для получения данных из вью модели, подписываемся на нужную лайв дату в методе onResume()
        vm.getEmployeeLiveData().observe(viewLifecycleOwner) {
            //Обновляем данные в адаптере
            employeeAdapter.updateEmployeeList(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            recyclerViewEmployee.adapter = employeeAdapter
            recyclerViewEmployee.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewEmployee.setItemViewCacheSize(20)
        }
    }
}