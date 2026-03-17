// logic when choice
fun logic(ask: Int?) {
    when (ask) {
        1 -> gamesMenu.choiceGames_Menu()
        2 -> usersSettings_Menu()
        3 -> promoGift_Menu()
        4 -> proporties_Menu()
        5 -> if (UserManager.ifAdmin() == true) { adminPanel_Menu() } else { presets.wrongChoice() }
        0 -> println("Выход...")
        else -> presets.wrongChoice()
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
        println("4 - Свойства [pre - alpha]")
        if (UserManager.ifAdmin() == true) { println("5 - Админ панель") }
        ask = input.int()
        logic(ask)
    }
}