// logic when choice
fun logic(ask: Int?) {
    when (ask) {
        1 -> Games_Menu.choiceGames_Menu()
        2 -> usersSettings_Menu()
        3 -> promoGift_Menu()
        4 -> adminPanel_Menu(ask)
        0 -> println("выход")
        else -> println("Неверный выбор")
    }
}

//        ||
// start \||/
//        \/
fun main() {
    var ask: Int? = 1
    while (ask != 0) {
        println("Меню (0 - выход)")
        println("1 - Игры")
        println("2 - Управление пользователем")
        println("3 - Ввод промокодов")
        if (UserManager.if_admin() == true) { println("4 - Админ панель") }
        ask = input.int()
        logic(ask)
    }
}