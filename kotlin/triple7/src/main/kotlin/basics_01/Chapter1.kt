package basics_01

fun main() {

// Chapter 1 Basics...
    println("Hello World, Welcome to Kotlin")
    // Taking input...
    val input = readLine()
    println("Input no : $input")

//	String Templates...
    var x = 5
    println("Its $x")
    val greetings = "Kotliner"
    println("Hello $greetings")

// Initializing Variable...
    // Val = Non-Mutable but var = Mutable
    //Type 1: Mentioning the DT(Explicit)
    val a: Int = 5
    println(a)
    //Type 2: Direct Initializing(Implicit)
    val b = 10
    println(b)
}