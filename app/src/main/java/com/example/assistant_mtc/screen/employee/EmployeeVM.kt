package com.example.assistant_mtc.screen.employee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sogya.mtc.domain.models.EmployeeDomain
import com.sogya.mtc.domain.models.EmployeeHeaderDomain

class EmployeeVM : ViewModel() {
    //Для инициализации листа, достаточно напсиать так, отдельыне классы создавать не нужно
    private val employeeList = arrayListOf(
        EmployeeHeaderDomain("Руководящий состав Военного учебного центра при РТУ МИРЭА"),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/737/7377cd49b93f954bea8491a8dcc6867a.jpg",
            "Каргапольцев Аркадий Аркадьевич",
            "Начальник Военного учебного центра, полковник запаса, кандидат военных наук, доцент",
            "kargapoltsev@mirea.ru",
            "+7(495)246-05-55",
            "доб. 601",
            "Аудитория 214"
        ),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/055/055021bbcd72a0498166b2738e4149fd.jpg",
            "Ситников Виктор Валерьевич",
            "Начальник учебной части - заместитель начальника Военного учебного центра, полковник",
            "sitnikov@mirea.ru",
            "+7(495)246-05-55",
            "доб. 602",
            "Аудитория 212"
        ),
        EmployeeHeaderDomain("Кафедра Воздушно-космических сил Военного учебного центра"),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/f1a/f1af74cff82b6386d61738372bd19dce.jpg",
            "Непорожнев Денис Александрович",
            "Начальник кафедры, полковник",
            "neporozhnev@mirea.ru",
            "+7(495)246-05-55",
            "доб. 612",
            "Аудитория 112"
        ),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/411/41175de9a7d75fb990cc78f9659601af.jpg",
            "Шубин Андрей Владимирович",
            "Доцент кафедры, подполковник запаса, кандидат военных наук",
            "shubin_a@mirea.ru",
            "+7(495)246-05-55",
            "доб. 606",
            "Аудитория 107"
        ),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/e77/e770c1309596d3849237e431e6ebab39.jpg",
            "Белоус Сергей Ильич",
            "Доцент кафедры, полковник запаса, кандидат военных наук",
            "belous@mirea.ru",
            "+7(495)246-05-55",
            "доб. 608",
            "Аудитория 108"
        ),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/d11/d11a124e1a1844c47f79e6a79484fb0f.jpg",
            "Гарманов Сергей Семенович",
            "Доцент кафедры, полковник запаса, кандидат военных наук",
            "garmanov@mirea.ru",
            "+7(495)246-05-55",
            "доб. 607",
            "Аудитория 309"
        ),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/c80/c802d1135f7e069208978a34e360a8c1.jpg",
            "Пантелеев Николай Николаевич",
            "Преподаватель кафедры, подполковник запаса",
            "panteleev@mirea.ru",
            "+7(495)246-05-55",
            "доб. 606",
            "Аудитория 107"
        ),
        EmployeeHeaderDomain("Кафедра Связи Военного учебного центра"),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/7fd/7fd2cfac8af28029916770ff1092fb8a.jpg",
            "Моисеев Александр Петрович",
            "Старший преподаватель, полковник запаса",
            "moiseev@mirea.ru",
            "+7(495)246-05-55",
            "доб. 605",
            "Аудитория 505"
        ),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/6cf/6cffa8c38aec266016b818cdabb79c1b.jpg",
            "Шумилов Александр Николаевич",
            "Преподаватель кафедры, полковник запаса",
            "shumilov@mirea.ru",
            "+7(495)246-05-55",
            "доб. 605",
            "Аудитория 505"
        ),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/e2b/e2b32e92cacee8d04142117bc0d418a1.jpg",
            "Алексеев Алексей Анатольевич",
            "Преподаватель кафедры, полковник запаса",
            "alekseev_a@mirea.ru",
            "+7(495)246-05-55",
            "доб. 611",
            "Аудитория 510"
        ),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/7e6/7e6286342e0aa5d89855a9761854bdac.jpg",
            "Савелов Геннадий Александрович",
            "Преподаватель кафедры, полковник запаса",
            "savelov@mirea.ru",
            "+7(495)246-05-55",
            "доб. 611",
            "Аудитория 510"
        ),
        EmployeeHeaderDomain("Кафедра Общевоенной подготовки Военного учебного центра"),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/f14/f145dd7c546f56295a919cb525c4391b.jpg",
            "Чёрный Артем Андреевич",
            "Начальник учебной части - заместитель начальника кафедры, подполковник запаса",
            "",
            "+7(495)246-05-55",
            "доб. 607",
            "Аудитория 206"
        ),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/0a0/0a0d66c92b4b23fde0bcd8ad28e58138.jpg",
            "Филимонов Александр Евгеньевич",
            "Доцент кафедры, подполковник запаса, кандидат технических наук, профессор Академии военных наук",
            "filimonov_ae@mirea.ru",
            "+7(495)246-05-55",
            "доб. 613",
            "Аудитория 302"
        ),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/fa4/fa4c9704a0b51ac2d78ec6093e7542e5.jpg",
            "Резников Геннадий Аркадьевич",
            "Доцент кафедры, подполковник запаса, кандидат военных наук",
            "reznikov@mirea.ru",
            "+7(495)246-05-55",
            "доб. 613",
            "Аудитория 302"
        ),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/23a/23a110ca25a78d0b862d3367f5a16aac.jpg",
            "Крылов Александр Васильевич",
            "Старший преподаватель кафедры, майор запаса",
            "krylov_a@mirea.ru",
            "+7(495)246-05-55",
            "доб. 607",
            "Аудитория 309"
        ),
        EmployeeDomain(
            "https://vuc.mirea.ru/upload/medialibrary/ca0/ca0babb75181056227916eb09f65f69a.jpg",
            "Губарев Сергей Александрович",
            "Преподаватель кафедры, подполковник запаса",
            "gubarev_s@mirea.ru",
            "+7(495)246-05-55",
            "доб. 607",
            "Аудитория 309"
        )
    )

    // Через лайв дату, данные передаются из вью модели на экран.
    // Это позволяет выводить на экарн актуальные данные, ведь изменения отобразяться моментально
    private val employeeLiveData = MutableLiveData<List<Any>>()

    fun getEmployeeLiveData(): LiveData<List<Any>> = employeeLiveData

    init {
        employeeLiveData.value = employeeList
    }
}