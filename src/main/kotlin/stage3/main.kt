package stage3

val listOfPeople = mutableListOf<String>()

fun main() {
    println("Enter the number of people:")
    val number = readln().toInt()

    println("Enter all people:")

    repeat(number) {
        listOfPeople.add(readln())
    }
    loopMenu()
}

fun loopMenu() {
    while(true) {
        println("=== Menu ===")
        println("1. Find a person")
        println("2. Print all people")
        println("0. Exit")
        when (readln()) {
            "1" -> findWords(enterNumber(), listOfPeople)
            "2" -> printAllPeople()
            "0" -> { println("\nBye") ;  break}
            else -> println("\nIncorrect option! Try again.")
        }
    }
}

fun findWords(word: String, list: MutableList<String>) {
    val results = mutableListOf<String>()
    var index = 0
    for (i in list) {
        var n = 0
        for (j in list[index]) {
            if (j.lowercase() == word[n].lowercase() && n < word.length - 1) {  // lowercase()
                n++
            } else if (j.lowercase() == word[n].lowercase()) {
                results.add(list[index])
                break
            } else {
                n = 0
            }
        }
        index++
    }

    if (results.isEmpty()) {
        println("No matching people found.")
    } else {
        println()
        println("People found:")
        results.forEach { println(it) }
    }
    println()
}

fun enterNumber(): String {
    println("Enter a name or email to search all suitable people.")
    return readln().lowercase()
}

fun printAllPeople() {
    println("=== List of people ===")
    listOfPeople.forEach { println(it) }
    println()
}


// подсказка don't convert any input or output text to lowercase,
// just use in the search contains(search_word, ignoreCase = true)
