package com.example.assistant_mtc.screen.employee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assistant_mtc.R
import com.sogya.mtc.domain.models.EmployeeDomain

class EmployeeVM : ViewModel() {
    //Для инициализации листа, достаточно напсиать так, отдельыне классы создавать не нужно
    private val employeeList = arrayListOf(
        EmployeeDomain(R.drawable.employee1, "Каргапольцев Аркадий Аркадьевич", "Начальник Военного учебного центра, полковник запаса, кандидат военных наук, доцент", "kargapoltsev@mirea.ru", "+7(495)246-05-55, доб. 601", "Аудитория 214"),
        EmployeeDomain(R.drawable.employee2, "Ситников Виктор Валерьевич", "Начальник учебной части - заместитель начальника Военного учебного центра, полковник", "sitnikov@mirea.ru", "+7(495)246-05-55, доб. 602", "Аудитория 212"),
        EmployeeDomain(R.drawable.employee3, "Непорожнев Денис Александрович", "Начальник кафедры, полковник", "neporozhnev@mirea.ru", "+7(495)246-05-55, доб. 612", "Аудитория 112"),
        EmployeeDomain(R.drawable.employee4, "Шубин Андрей Владимирович", "Доцент кафедры, подполковник запаса, кандидат военных наук", "shubin_a@mirea.ru", "+7(495)246-05-55, доб. 606", "Аудитория 107"),
        EmployeeDomain(R.drawable.employee5, "Белоус Сергей Ильич", "Доцент кафедры, полковник запаса, кандидат военных наук", "belous@mirea.ru","+7(495)246-05-55, доб. 608", "Аудитория 108")
    )

    // Через лайв дату, данные передаются из вью модели на экран.
    // Это позволяет выводить на экарн актуальные данные, ведь изменения отобразяться моментально
    private val employeeLiveData = MutableLiveData<List<EmployeeDomain>>()

    fun getEmployeeLiveData(): LiveData<List<EmployeeDomain>> = employeeLiveData

    init {
        employeeLiveData.value = employeeList
    }
}