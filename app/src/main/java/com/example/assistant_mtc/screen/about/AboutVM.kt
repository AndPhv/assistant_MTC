package com.example.assistant_mtc.screen.about

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sogya.mtc.domain.models.AboutDomain
import com.sogya.mtc.domain.models.AboutFutureDomain
import com.sogya.mtc.domain.utils.CallbackListener
import com.sogya.mtc.domain.utils.Constants

class AboutVM : ViewModel() {
    private val aboutList = arrayListOf(
        AboutDomain(
            "Что такое Военный учебный центр при РТУ МИРЭА?",
            "Военный учебный центр (ВУЦ) — это структурное подразделение РТУ МИРЭА, которое предоставляет возможность пройти военную службу без отрыва от учебы и получить военно-учетную специальность.\n" +
                    "\n" +
                    "Военный учебный центр при РТУ МИРЭА имеет давнюю историю и традиции, являясь преемником военной кафедры МИРЭА, основанной в 1969 году. \n" +
                    "\n" +
                    "Студенты ВУЦ проходят обучение параллельно с занятиями в университете, а выпускники ВУЦ направляются на 30-дневные учебные сборы и после аттестации зачисляются в запас, с присвоением первого воинского звания и личного номера."
        ),
        AboutDomain(
            "Военный учебный центр при РТУ МИРЭА проводит подготовку:",
            " - офицеров запаса по семи военно - учетным специальностям,\n" +
                    "\n" +
                    " - сержантов запаса по одной военно - учетной специальности,\n" +
                    "\n" +
                    " - солдат запаса по двум военно - учетным специальностям.\n" +
                    "\n" +
                    "Обучение в ВУЦ является добровольным, отбор кандидатов проводится на конкурсной основе. Студенты, не прошедшие обучение в ВУЦ, после окончания университета обязаны пройти военную службу по призыву или альтернативную гражданскую службу в соответствии с законодательством Российской Федерации.\n" +
                    "\n" +
                    "Миссия ВУЦ — укрепление оборонного потенциала России через создание квалифицированных военных кадров. Развитие интеллектуальных, физических и морально — волевых качеств студентов. Воспитание достойных граждан и патриотов.\n" +
                    "\n" +
                    "Ценности ВУЦ — патриотизм, стремление защищать народ и Отечество. Верность воинскому долгу и присяге. Коллективизм, готовность помочь товарищу в беде, честность, отзывчивость и взаимопомощь. Компетентность, постоянное совершенствование профессиональных навыков сотрудников и учащихся ВУЦ.\n" +
                    "\n" +
                    "Девиз ВУЦ — через знания к победе."
        ),
        AboutFutureDomain(
            mailAddress = "Почтовый адрес: 119454 г. Москва, проспект Вернадского, 78, Военный учебный центр.",
            address = "Адрес: 119048 г. Москва, улица Усачева, 7/1",
            dutyNumber = "Дежурный: +7 (499) 600-86-03",
            studyNumber = "Учебная часть: +7 (495) 246-05-55 доб. 604",
            email = "Email: vuc@mirea.ru",
            telegramNews = "Telegram: Новости",
            telegramBot = "Telegram: Бот"
        )
    )

    private val aboutLiveData = MutableLiveData<List<Any>>()


    fun getAboutLiveData(): LiveData<List<Any>> = aboutLiveData
    fun openTelegramByCommand(command: String, callbackListener: CallbackListener<Intent>) {
        when (command) {
            Constants.OPEN_TG_NEWS -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/wutz_mirea"))
                callbackListener.data(intent)
            }
            Constants.OPEN_TG_BOT -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/vuc_mirea_bot"))
                callbackListener.data(intent)
            }
            Constants.OPEN_ADDRESS -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=55.728647,37.573097"))
                callbackListener.data(intent)
            }
        }
    }

    init {
        aboutLiveData.value = aboutList
    }
}