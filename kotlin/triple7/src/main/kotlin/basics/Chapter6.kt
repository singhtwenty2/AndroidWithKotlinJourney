package basics

fun main(){
    // Chapter 6 Functions...
    // Keyword 'fun' is used to make functions in kotlin

    greet("Aryan")

    println(sum(5,7))

    sayGreet("Good Morning","Aryan")
    sayGreet(name = "Aryan", event = "Good Afternoon") // We can change the order of args unlike java
    sayGreet() // If we do not supply args then it will take the default values, If we want to use the same thing in java then we have to use Method Overloading
}
fun greet(name: String){ // Function with no return
    println("Hello $name, Welcome")
}

fun sum(a: Int,b: Int) : Int { // Function with return
    return a+b
}

// In Kotlin, we have something similar as named and positional arguments from dart
fun sayGreet(event: String = "Default Greet", name: String = "Default Name"){
    println("Hello $name, $event")
}