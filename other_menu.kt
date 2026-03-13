// choice games
object Games_Menu {
    fun choiceGames_Menu() {
        var Games_Menu_input: Int? = 1
        while (Games_Menu_input != 0) {
            println("Меню игр (0 - выход)")
            println("1 - Повторение")
            println("2 - Скоро...")
            Games_Menu_input = input.int()
            
            when (Games_Menu_input) {
                1 -> repeaterGame_Menu()
                2 -> println("Скоро...")
                0 -> println("выход")
                else -> println("Неверный выбор $Games_Menu_input")
            }
        }
    }
    //      \||/
    // games \/
    fun repeaterGame_Menu() {
        var repeaterGame_input: String? = ""
        println("Повторялка (0 - выход)")
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
        println("Меню пользователя (0 - выход)")
        println("1 - Установка")
        println("2 - Переименование")
        if (UserManager.if_admin() == true) { println("3 - Снятие прав") }
        usersSettings_input = input.int("notext")
        // when choice
        when (usersSettings_input) {
            1 -> UserManager.reg("Введите имя")
            2 -> UserManager.rename("Введите новое имя")
            3 -> if (UserManager.if_admin() == true) { UserManager.status_admin(false) }
            0 -> println("выход")
            else -> println("Неверный выбор $usersSettings_input")
        }
    }
}

// promocodes
fun promoGift_Menu() {
    var promoGift_input: String? = input.str("Введите промокод")
    if (promoGift_input == "admin_add") {
        println("Промокод активирован...")
        UserManager.status_admin(true)
    } else { println("Промокод ненайден") }
}
// admin panel (promo admin_add)
fun adminPanel_Menu(ask: Int?) {
    if (UserManager.if_admin() == true) {
        println("Админ панель не сделана.") 
    } else { println("Неверный выбор $ask") }
}