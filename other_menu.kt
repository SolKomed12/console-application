// class all games and choice games
object gamesMenu {
    // choice game menu
    fun choiceGames_Menu() {
        var Games_Menu_input: Int? = 1
        while (Games_Menu_input != 0) {
            println("Меню игр (0 - назад)")
            println("1 - Повторение")
            println("2 - Скоро...")
            Games_Menu_input = input.int()
            // if game

            when (Games_Menu_input) {
                1 -> repeaterGame_Menu()
                2 -> println("Скоро...")
                0 -> println("")
                else -> presets.wrongChoice()
            }
        }
    }
    //  all \||/
    // games \/
    private fun repeaterGame_Menu() {
        var repeaterGame_input: String? = ""
        println("Повторялка (0 - назад)")
        while (repeaterGame_input != "0") {
            repeaterGame_input = input.str()
            println(repeaterGame_input)
        }
    }
}

// users settings
fun usersSettings_Menu() {
    var usersSettings_input: Int? = 1
    while (usersSettings_input != 0) {
        // menu
        println("Меню пользователя (0 - назад)")
        println("1 - Установка")
        println("2 - Переименование")
        if (UserManager.ifAdmin() == true) { println("3 - Снятие прав") }
        usersSettings_input = input.int()
        
        when (usersSettings_input) {
            1 -> UserManager.regUser("Введите имя")
            2 -> UserManager.rename("Введите новое имя")
            3 -> if (UserManager.ifAdmin()) { UserManager.statusAdmin(false) } else { presets.wrongChoice() }
            0 -> println("")
            else -> presets.wrongChoice()
        }
    }
}

// promocodes
fun promoGift_Menu() {
    var promoGift_input: String? = input.str("Введите промокод")
    if (promoGift_input == "admin_add") {
        println("Промокод активирован...")
        UserManager.statusAdmin(true)
    } else { println("Промокод ненайден") }
}
// admin panel (promo admin_add)
fun adminPanel_Menu() {
    println("Админ панель не сделана.") 
}
fun proporties_Menu() {
    println("Консольное приложение")
    println("Пользователь: ${Properties.username()}")
    println("Админ доступ: ${Properties.admin()}")
}