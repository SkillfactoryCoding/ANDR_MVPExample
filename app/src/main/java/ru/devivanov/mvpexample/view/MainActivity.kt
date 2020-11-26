package ru.devivanov.mvpexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.devivanov.mvpexample.App
import ru.devivanov.mvpexample.R
import ru.devivanov.mvpexample.presenter.BasePresenter

class MainActivity : AppCompatActivity(), BaseView {
    //Создаем переменную под наш презентер
    private lateinit var presenter: BasePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Инициализируем наш презентер уже созданным презентером из класса App
        presenter = App.instance.mainPresenter
        //Передаем в презентер ссылку на наше активити
        presenter.attachPresenter(this)
        //Вызываем метод презентера, чтобы получить от него наш список из БД
        button.setOnClickListener {
            presenter.getListFromDB()
        }
    }

    override fun setListForView(list: List<String>) {
        var string = ""
        list.forEach {
            string += it
        }
        text_view.text = string
    }
}