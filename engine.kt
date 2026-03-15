
// -------------------------------
// version 2.5.6 developer SolKomed
// -------------------------------

// optional, for work user
var user_name: String? = null
var admin_protection: Boolean = false
var prefix: String = ""

// for string in null
fun String.toOrNull() = ifBlank { null }
// readln
object input {
    // optional, for work int, string
    fun invitation() {
        if (user_name != null) {
            print("$prefix<$user_name> ")
        } else { print(">>> ") }
    }
    // for string necessarily: ?
    fun str(text: String = "notext"): String? {
        if (text != "notext") { println(text) }
        invitation()
        return readln().toOrNull()
    }
    // for int necessarily: ?
    fun int(text: String = "notext"): Int? {
        if (text != "notext") { println(text) }
        invitation()
        return readln().toIntOrNull()
    }
}

// wrongchoice for all func wrong choice
fun wrongChoice() { println("Неверный выбор.") }

// manager user for properites in main.kt, other_menu.kt
object UserManager {
    // if admin
    fun if_admin(): Boolean { return admin_protection }
    // rename user
    fun rename(text: String) {
        var new_name: String? = input.str(text)
        if (user_name != null) {
            user_name = new_name
            println("Имя изменено.")
        } else { println("Ненайден пользователь.") }
    }
    fun ifPrefix() {
        when (if_admin()) {
            true -> prefix = "[Admin]"
            else -> prefix = ""
        }
    }
    // register user
    fun reg(text: String, status: String="user") {
        var name: String? = input.str(text)
        when (status) {
            "user" -> User(name)
            else -> Admin(name)
        }
    }
    // change status user
    fun status_admin(status: Boolean) {
        if (user_name != null) {
            admin_protection = status
            println(if (status) "Права повышены" else "Права сняты")
            ifPrefix()
        } else { println("Ненайден пользователь.") }
    }
}
// basic class
open class User(name: String?) {
    init {
        println("Пользователь $name создан!")
        user_name = name
    }
}
// for class User
class Admin(name: String?): User(name) {
    init {
        println ("Добавление прав администратора.")
        admin_protection = true
        UserManager.ifPrefix()
    }
}