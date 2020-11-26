package ru.devivanov.mvpexample.data

class AppDataBase : BaseDataBase {
    private val db = listOf(
        "one",
        "two",
        "three"
    )
    override fun returnBase(): List<String> {
        return db
    }
}