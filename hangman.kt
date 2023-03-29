package io

fun main() {
    print("Enter the word to guess: ")
    val word = readLine()
    if (word === null) {
        println("No word given, game ended.")
        return
    }
    for (i in 1..100) {
        println()
    }

    val letters = word.lowercase().toCharArray().toHashSet()
    val correctGuesses = mutableSetOf<Char>()
    var fails = 0

    while (letters != correctGuesses) {
        printExploredWord(word, correctGuesses)
        println("\n#Wrong guesses: $fails")

        print("Guess letter: ")
        val input = readLine()

        if (input == null) {
            continue
        } else if (input.length != 1) {
            println("Please enter 1 letter")
            continue
        }

        if (word.lowercase().contains(input.lowercase())) {
            correctGuesses.add(input.toString().lowercase()[0])
        } else {
            fails++
        }
    }

    printExploredWord(word, correctGuesses)
    println("Number of wrong guesses: $fails\n\n")
    println("Well done.")
}

fun printExploredWord(word: String, correctGuesses: Set<Char>): String {
    val formattedWord = StringBuilder()
    for (character in word.lowercase()) {
        if (correctGuesses.contains(character)) {
            formattedWord.append(character + " ")
        } else {
            formattedWord.append("_ ")
        }
    }
    println(formattedWord)
    return formattedWord.toString()
}


//fun printExploredWord(word: String, correctGuesses: Set<Char>) {
//    for (character in word.lowercase()) {
//        if (correctGuesses.contains(character)) {
//            print(character + " ")
//        } else {
//            print("_ ")
//        }
//    }
//}