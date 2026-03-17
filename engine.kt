
// -------------------------------
// version 2.6.4 developer SolKomed
// -------------------------------

// optional, for work user
private var user_name: String? = null
private var admin_protection: Boolean = false
private var prefix: String = " "

// for string in null
fun String.toOrNull() = ifBlank { null }
// readln
object input {
    // optional, for work int, string
    private fun invitation(text: String) {
        if (text != "notext") { println(text) }
        if (user_name != null) {
            print("$prefix<$user_name> ")
        } else { print(">>> ") }
    }
    // for string necessarily: ?
    fun str(text: String = "notext"): String? {
        invitation(text)
        return readln().toOrNull()
    }
    // for int necessarily: ?
    fun int(text: String = "notext"): Int? {
        invitation(text)
        return readln().toIntOrNull()
    }
}

// presets for speed sentenc
object presets {
    // wrongchoice for all func wrong choice
    fun wrongChoice() { println("Неверный выбор.") }
}

object returnProperties {
    fun username(): String? { return if (user_name != null) user_name else { "нет" } }
}

// manager user for properites in main.kt, other_menu.kt
object UserManager {
    private fun nonUserToAdmim() {
        println("Ненайден пользователь.")
        var choice: String? = input.str("Создать пользователя? (yes, no)")
        when (choice) {
            "yes" -> regUser("Введите имя", "admin")
            "no" -> println("Отменено.")
            else -> presets.wrongChoice()
        }
    }
    // if admin
    fun ifAdmin(): Boolean { return admin_protection }
    // rename user
    fun rename(text: String) {
        var new_name: String? = input.str(text)
        if (user_name != null) {
            user_name = new_name
            println("Имя изменено.")
        } else { println("Ненайден пользователь.") }
    }
    // optional, for work prefix
    fun ifPrefix() {
        when (ifAdmin()) {
            true -> prefix = "[Admin] "
            else -> prefix = " "
        }
    }
    // register user
    fun regUser(text: String, status: String="user") {
        var name: String? = input.str(text)
        when (status) {
            "user" -> User(name)
            "admin" -> Admin(name)
            else -> println("Внутренняя ошибка.")
        }
    }
    // change status user
    fun statusAdmin(status: Boolean) {
        if (user_name != null) {
            admin_protection = status
            println(if (status) "Права повышены" else "Права сняты")
            ifPrefix()
        } else { nonUserToAdmim() }
    }
}
// basic class
open class User(name: String?) {
    init {
        println("Пользователь $name создан.")
        user_name = name
    }
}
// for class User
class Admin(name: String?): User(name) {
    init {
        admin_protection = true
        UserManager.ifPrefix()
    }
}