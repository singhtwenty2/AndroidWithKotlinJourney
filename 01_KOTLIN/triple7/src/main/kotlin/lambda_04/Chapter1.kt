package lambda_04

//SYNTAX OF LAMBDA EXP

fun main() {
    /*
    Two Ways to call lambda ::
    1. Add Parenthesis after the variable name
    2. call invoke() method
     */
    val printGreetMessage = { println("Welcome and Good Morning...") }
    // Calling the lambda
    printGreetMessage()
    printGreetMessage.invoke()
    // General Syntax
  //val lambda: (DT1, DT2) -> ReturnType = {var1: DT1, var2: DT2 -> method_body}
    val add: (Int, Int) -> Int = {a: Int, b: Int -> a + b}
    // Another way of writing
    val add1 = {a: Int, b: Int -> a + b}
    // Another way of writing
    val add2: (Int, Int) -> Int = {a, b-> a + b}
    println(add(4, 6))
    println(add1(5, 6))
    println(add2(6, 6))
}

/*
fun add(x: Int, y: Int): Int {
    return (x + y)
}
Is Same as bellow
{x, y -> x + y}
 */