package basics_01

fun main() {
// Chapter 4 Array
    val names = arrayOf("Apple","Samsung","Google")
    // for each loop
    for(name in names) {
        println(name)
    }
    println(names[0])

// Ranges...
    for(i in 0..3) {             // Type-1
        print(i)
    }
    print(" ")

    for(i in 0 until 3) {        // Type-2
        print(i)
    }
    print(" ")

    for(i in 2..8 step 2) {      // Type-3
        print(i)
    }
    print(" ")

    for (i in 3 downTo 0) {      // Type-4
        print(i)
    }
    println()
// Range can be used with if-else statement...
    val x = 2
    if (x in 1..5) {            // 1
        print("$x is in range from 1 to 5")
    }
    println()

    if (x !in 6..10) {          // 2
        print("$x is not in range from 6 to 10")
    }
}