package machine
import java.util.Scanner

val scanner = Scanner(System.`in`)
var waterAmount = 400
var milkAmount = 540
var beansAmount = 120
var moneyAmount = 550
var cupsAmount = 9

fun printStatus() {
    println("\nThe coffee machine has:")
    println("$waterAmount of water")
    println("$milkAmount of milk")
    println("$beansAmount of coffee beans")
    println("$cupsAmount of disposable cups")
    println("$$moneyAmount of money")
}

fun isPossbile(water: Int, milk: Int, beans: Int): Boolean {
    var out = true
    if (waterAmount < water) {
        println("Sorry, not enough water!")
        out = false
    }
    if (milkAmount < milk) {
        println("Sorry, not enough milk!")
        out = false
    }
    if (beansAmount < beans) {
        println("Sorry, not enough coffee beans!")
        out = false
    }
    if (cupsAmount < 1) {
        println("Sorry, not enough cups!")
        out = false
    }
    return out
}

fun espresso() {
    if (isPossbile(250, 0, 16)) {
        waterAmount -= 250
        beansAmount -= 16
        cupsAmount -= 1
        moneyAmount += 4
        println("I have enough resources, making you a coffee!")
    }

}

fun latte() {
    if (isPossbile(350, 75, 20)) {
        waterAmount -= 350
        milkAmount -= 75
        beansAmount -= 20
        cupsAmount -= 1
        moneyAmount += 7
        println("I have enough resources, making you a coffee!")
    }
}

fun cappuccino() {
    if (isPossbile(200, 100, 12)) {
        waterAmount -= 200
        milkAmount -= 100
        beansAmount -= 12
        cupsAmount -= 1
        moneyAmount += 6
        println("I have enough resources, making you a coffee!")
    }
}

fun buy() {
    println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: > ")
    when (scanner.next()) {
        "1" -> {
            espresso()
        }
        "2" -> {
            latte()
        }
        "3" -> {
            cappuccino()
        }
    }
}

fun fill() {
    println("Write how many ml of water do you want to add: > ")
    waterAmount += scanner.nextInt()
    println("Write how many ml of milk do you want to add: < ")
    milkAmount += scanner.nextInt()
    println("Write how many grams of coffee beans do you want to add: > ")
    beansAmount += scanner.nextInt()
    println("Write how many disposable cups of coffee do you want to add: > ")
    cupsAmount += scanner.nextInt()
}

fun take() {
    println("\nI gave you $$moneyAmount")
    moneyAmount = 0
    println("")
}

fun main(args: Array<String>) {

    do {
        println("")
        println("Write action (buy, fill, take, remaining, exit): > ")
        val action = scanner.next()

        when (action) {
            "remaining" -> printStatus()
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
        }
    } while(action != "exit")
}
