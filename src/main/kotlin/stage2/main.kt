package stage2

fun main() {
    println("Enter the number of people:")
    val number = readln().toInt()

    println("Enter all people:")
    val listOfPeople = mutableListOf<String>()
    repeat(number) {
        listOfPeople.add(readln()) // .lowercase())  // .split("\\s+".toRegex()).toString())  // .toMutableList())
    }

    println("Enter the number of search queries:")
    val numberOfQueries = readln().toInt()
    repeat(numberOfQueries) {
        println()
        println("Enter data to search people:")
        val word = readln().lowercase()
        findWords(word, listOfPeople)
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
}

  //  val str3 = "abcd"
  //  val word2 = "bc"
/*
    var n = 0
    for (i in str3) {
        if (i == word2[n] && n < word2.length - 1) {
            n++
        } else if (i == word2[n]) {
            println(str3)
            n = 0
        } else {
            n = 0
        }
    }
*/

// подсказка don't convert any input or output text to lowercase,
// just use in the search contains(search_word, ignoreCase = true)

/*
Ошибка

Wrong answer in test #2

Search result is not equal to the expected in search iteration 0

Please find below the output of your program during this failed test.
Note that the '>' character indicates the beginning of the input line.

---

Enter the number of people:
> 3
Enter all people:
> john smith smith@gmail.com
> John lock john_lock@somecompany.com
> help me iamaprogrammer@gmail.com
Enter the number of search queries:
> 4

Enter data to search people:
> john

People found:
john smith smith@gmail.com
john lock john_lock@somecompany.com

Enter data to search people:
> Somecompany

People found:
john lock john_lock@somecompany.com

Enter data to search people:
> @

People found:
john smith smith@gmail.com
john lock john_lock@somecompany.com
help me iamaprogrammer@gmail.com

Enter data to search people:
> this text will definitely be no match
No matching people found.
 */