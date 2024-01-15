package basics

fun main() {
    /*Chapter 3 If-else and when(Switch case)

	*/
    // if-else...
    val age = 2
    if(age >= 18) {
        println("You can vote")
    }
    else {
        println("You can't vote")
    }
// In kotlin an if-else statement can return a value
    val value: Int = if(true) {
        println("Block 1")
        10
    }
    else {
        println("Block 2")
        20
    }
    println(value)

    // When (Equivalent to Switch case in java with almost same syntax)...
    val word = "Hello"
    when(word) {
        "Hello"-> {
            println("Hello")
        }
        "world"-> {
            println("world")
        }
        else-> {
            println("Something else...")
        }
    }
}