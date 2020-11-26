package ru.devivanov.mvpexample

import android.app.Application
import ru.devivanov.mvpexample.data.AppDataBase
import ru.devivanov.mvpexample.data.BaseDataBase
import ru.devivanov.mvpexample.presenter.BasePresenter
import ru.devivanov.mvpexample.presenter.MainPresenter

class App: Application() {
    //Переменные для наших компонентов
    lateinit var dataBase: BaseDataBase
    lateinit var mainPresenter: BasePresenter

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Инициализируем наши компоненты
        dataBase = AppDataBase()
        mainPresenter = MainPresenter(dataBase)
    }
    //Здесь у нас экземпляр нашего класса Application через который у нас будет доступ к нашим компонентам
    companion object {
        lateinit var instance: App
            private set
    }
}