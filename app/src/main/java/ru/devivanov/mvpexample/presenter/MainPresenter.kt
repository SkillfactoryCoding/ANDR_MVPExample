package ru.devivanov.mvpexample.presenter

import android.app.Activity
import ru.devivanov.mvpexample.data.BaseDataBase
import ru.devivanov.mvpexample.view.MainActivity

class MainPresenter(private val dataBase: BaseDataBase) : BasePresenter {
    //Здесь будет ссылка на наше активити
    private lateinit var mainActivity: MainActivity
    //Этот метод буде вызыватся в активити и в параметр будет передеваться ссылка на активити через this
    override fun attachPresenter(activity: Activity) {
        mainActivity = activity as MainActivity
    }

    override fun getListFromDB() {
        val list = dataBase.returnBase()
        mainActivity.setListForView(list)
    }
}