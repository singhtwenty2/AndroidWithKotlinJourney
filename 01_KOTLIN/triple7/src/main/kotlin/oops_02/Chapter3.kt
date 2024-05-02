package oops_02

// FUNCTIONS AKA METHODS IN KOTLIN
fun main() {
    /*
    Functions are block of code that encapsulate a specific task or functionality.
    FUNCTION DECLARATION...
    fun method_name(para1: Type, para2: Type): MethodReturnType {
        FUNCTION BODY
        Perform operations or return a value
        }
        Unit == Void in JAVA
     */
    sayHello(name = "Amaresh Kumar Yadav")
    val result = sumTwoNum(20, 21)
    println(result)
}

fun sayHello(name: String): Unit {
    println("Hello $name")
}
fun sumTwoNum(num1: Int, num2: Int): Int {
    return (num1 + num2)
}