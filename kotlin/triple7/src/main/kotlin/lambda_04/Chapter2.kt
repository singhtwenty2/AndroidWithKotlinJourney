package lambda_04

// BASICS OF LAMBDA EXP
fun main() {
    /*
    Lambda Exp: Concise way of defining anonymous functions
    Basic LE = {params -> body}
     */
    // Types of Lambda Exp
    // Type 1 : With para & return type
    val mul: (Int, Int) -> Int = {a, b -> a * b}
    println(mul(4,6))
    // Type 2 : with para but no return type
    val addition: (Int, Int) -> Unit = {a, b -> println(a + b) }
    addition(18, 2)
    // Type 3 : no para but return type
    val greet: () -> String = {"Welcome & Good Morning..."}
    println(greet.invoke())
    // Type 4 : no para & no return type
    val m4: () -> Unit = { println("Type 4") }
    m4.invoke()
    // Direct Lambda Expression
    println({a: Int, b: Int -> a * b} (6, 8))
}