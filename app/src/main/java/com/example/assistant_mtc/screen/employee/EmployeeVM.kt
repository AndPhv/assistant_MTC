package com.example.assistant_mtc.screen.employee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sogya.mtc.domain.models.EmployeeDomain

class EmployeeVM : ViewModel() {
    //Для инициализации листа, достаточно напсиать так, отдельыне классы создавать не нужно
    private val employeeList = arrayListOf(
        EmployeeDomain("Каргапольцев Аркадий Аркадьевич", "111"),
        EmployeeDomain("Ситников Виктор Валерьевич", "222"),
        EmployeeDomain("Непорожнев Денис Александрович", "333"),
        EmployeeDomain("Шубин Андрей Владимирович", "444"),
        EmployeeDomain("Белоус Сергей Ильич", "555")
    )

    // Через лайв дату, данные передаются из вью модели на экран.
    // Это позволяет выводить на экарн актуальные данные, ведь изменения отобразяться моментально
    private val employeeLiveData = MutableLiveData<List<EmployeeDomain>>()

    fun getEmployeeLiveData(): LiveData<List<EmployeeDomain>> = employeeLiveData

    init {
        employeeLiveData.value = employeeList
    }
}