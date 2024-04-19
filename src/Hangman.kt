import java.util.*
import kotlin.random.Random

val words = listOf(
    "apple",
    "banana",
    "carrot",
    "dog",
    "elephant",
    "fish",
    "guitar",
    "house",
    "igloo",
    "jacket",
    "kite",
    "lion",
    "monkey",
    "notebook",
    "orange",
    "penguin",
    "queen",
    "rabbit",
    "snake",
    "tiger",
    "umbrella",
    "violin",
    "whale",
    "xylophone",
    "yacht",
    "zebra"
)

var word = ""
val guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0

fun main(args: Array<String>) {
    setupGame()
}

fun setupGame() {
    val wordIndex = Random.nextInt(words.size)
    word = words[wordIndex].uppercase(Locale.getDefault())
    println(word)

    for (i in word.indices) {
        guesses.add('_')
    }

    var gameOver = false
    do {
        printGameStatus()
        println("Please enter a letter:")
        var input = readLine() ?: ""
        if (input.isEmpty()) {
            println("That is not a valid input. Please try again.")
        } else {
            val letter = input[0].uppercaseChar()
            if (word.contains(letter)) {
                for (i in word.indices) {
                    if (word[i] == letter) {
                        guesses[i] = letter
                    }
                    if (!guesses.contains('_')) {
                        gameOver = true
                    }
                }
            } else {
                println("Sorry, that is not part of the word")
                remainingGuesses--
                mistakes++
                if (mistakes == 6) {
                    gameOver = true
                }
            }
        }
    } while (!gameOver)

    if (mistakes == 6) {
        printGameStatus()
        println("Sorry, you lost. The word was: $word")
    } else {
        println("Congratulations, you win!")
        println("The word was: $word")
    }
}

fun printGameStatus() {
    when (mistakes) {
        0 -> printZeroMistakes()
        1 -> printOneMistake()
        2 -> printTwoMistakes()
        3 -> printThreeMistakes()
        4 -> printFourMistakes()
        5 -> printFiveMistakes()
        6 -> printSixMistakes()
    }
    print("Word: ")
    for (element in guesses) {
        print("$element ")
    }
    println("\nYou have $remainingGuesses guess(es) left")
}

fun printZeroMistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun printOneMistake() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun printTwoMistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |      | ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun printThreeMistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /| ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun printFourMistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun printFiveMistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     /  ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun printSixMistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     / \\")
    println(" /|\\      ")
    println("/ | \\     ")
}