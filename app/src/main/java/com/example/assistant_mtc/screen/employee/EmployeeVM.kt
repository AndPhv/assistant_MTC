package com.example.assistant_mtc.screen.employee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assistant_mtc.R
import com.sogya.mtc.domain.models.EmployeeDomain
import com.sogya.mtc.domain.models.EmployeeHeaderDomain

class EmployeeVM : ViewModel() {
    //Для инициализации листа, достаточно напсиать так, отдельыне классы создавать не нужно
    private val employeeList = arrayListOf(
        EmployeeHeaderDomain("Руководящий состав Военного учебного центра при РТУ МИРЭА"),
        EmployeeDomain(R.drawable.employee1, "Каргапольцев Аркадий Аркадьевич", "Начальник Военного учебного центра, полковник запаса, кандидат военных наук, доцент", "kargapoltsev@mirea.ru", "+7(495)246-05-55", "доб. 601", "Аудитория 214"),
        EmployeeDomain(R.drawable.employee2, "Ситников Виктор Валерьевич", "Начальник учебной части - заместитель начальника Военного учебного центра, полковник", "sitnikov@mirea.ru", "+7(495)246-05-55", "доб. 602", "Аудитория 212"),
        EmployeeHeaderDomain("Кафедра Воздушно-космических сил Военного учебного центра"),
        EmployeeDomain(R.drawable.employee3, "Непорожнев Денис Александрович", "Начальник кафедры, полковник", "neporozhnev@mirea.ru", "+7(495)246-05-55", "доб. 612", "Аудитория 112"),
        EmployeeDomain(R.drawable.employee4, "Шубин Андрей Владимирович", "Доцент кафедры, подполковник запаса, кандидат военных наук", "shubin_a@mirea.ru", "+7(495)246-05-55", "доб. 606", "Аудитория 107"),
        EmployeeDomain(R.drawable.employee5, "Белоус Сергей Ильич", "Доцент кафедры, полковник запаса, кандидат военных наук", "belous@mirea.ru","+7(495)246-05-55", "доб. 608", "Аудитория 108"),
        EmployeeDomain(R.drawable.employee6, "Гарманов Сергей Семенович", "Доцент кафедры, полковник запаса, кандидат военных наук", "garmanov@mirea.ru", "+7(495)246-05-55", "доб. 607", "Аудитория 309"),
        EmployeeDomain(R.drawable.employee7, "Пантелеев Николай Николаевич", "Преподаватель кафедры, подполковник запаса", "panteleev@mirea.ru", "+7(495)246-05-55", "доб. 606", "Аудитория 107"),
        EmployeeDomain(R.drawable.employee8, "Ренкавик Владимир Алексеевич", "Преподаватель кафедры, полковник запаса", "renkavik@mirea.ru", "+7(495)246-05-55", "доб. 606", "Аудитория 107"),
        EmployeeDomain(R.drawable.employee9, "Травин Виталий Львович", "Преподаватель кафедры, подполковник запаса", "travin@mirea.ru", "+7(495)246-05-55", "доб. 608", "Аудитория 108"),
        EmployeeHeaderDomain("Кафедра Связи Военного учебного центра"),
        EmployeeDomain(R.drawable.employee10,"Моисеев Александр Петрович", "Старший преподаватель, полковник запаса", "moiseev@mirea.ru", "+7(495)246-05-55", "доб. 605", "Аудитория 505"),
        EmployeeDomain(R.drawable.employee11,"Шумилов Александр Николаевич", "Преподаватель кафедры, полковник запаса", "shumilov@mirea.ru", "+7(495)246-05-55", "доб. 605", "Аудитория 505"),
        EmployeeDomain(R.drawable.employee12,"Алексеев Алексей Анатольевич", "Преподаватель кафедры, полковник запаса", "alekseev_a@mirea.ru", "+7(495)246-05-55", "доб. 611", "Аудитория 510"),
        EmployeeDomain(R.drawable.employee13,"Савелов Геннадий Александрович", "Преподаватель кафедры, полковник запаса", "savelov@mirea.ru", "+7(495)246-05-55", "доб. 611", "Аудитория 510"),
        EmployeeHeaderDomain("Кафедра Общевоенной подготовки Военного учебного центра"),
        EmployeeDomain(R.drawable.employee14,"Чёрный Артем Андреевич", "Начальник учебной части - заместитель начальника кафедры, подполковник запаса", "", "+7(495)246-05-55", "доб. 607", "Аудитория 206"),
        EmployeeDomain(R.drawable.employee15,"Филимонов Александр Евгеньевич", "Доцент кафедры, подполковник запаса, кандидат технических наук, профессор Академии военных наук", "filimonov_ae@mirea.ru", "+7(495)246-05-55", "доб. 613", "Аудитория 302"),
        EmployeeDomain(R.drawable.employee16,"Резников Геннадий Аркадьевич", "Доцент кафедры, подполковник запаса, кандидат военных наук", "reznikov@mirea.ru", "+7(495)246-05-55", "доб. 613", "Аудитория 302"),
        EmployeeDomain(R.drawable.employee17,"Крылов Александр Васильевич", "Старший преподаватель кафедры, майор запаса", "krylov_a@mirea.ru", "+7(495)246-05-55", "доб. 607", "Аудитория 309"),
        EmployeeDomain(R.drawable.employee18,"Губарев Сергей Александрович", "Преподаватель кафедры, подполковник запаса", "gubarev_s@mirea.ru", "+7(495)246-05-55", "доб. 607", "Аудитория 309")
    )

    // Через лайв дату, данные передаются из вью модели на экран.
    // Это позволяет выводить на экарн актуальные данные, ведь изменения отобразяться моментально
    private val employeeLiveData = MutableLiveData<List<Any>>()

    fun getEmployeeLiveData(): LiveData<List<Any>> = employeeLiveData

    init {
        employeeLiveData.value = employeeList
    }
}