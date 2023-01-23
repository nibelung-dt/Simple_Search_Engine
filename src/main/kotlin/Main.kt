fun main() {
    val str = readln()
    val word = readln()
    val str2 = str.split(" ") // .toList()

    if (str2.contains(word)) {
        for (i in str2.indices) {
            if (str2[i] == word) {
                println(i+1)
                break
            }
        }
    } else {
        println("Not found")
    }
}