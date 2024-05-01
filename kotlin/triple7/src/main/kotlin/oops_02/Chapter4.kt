package oops_02

// Method Overloading
fun main() {
    val result1 = sumNums(4 , 5)
    val result2 = sumNums(4.6, 6.67)
    val result3 = mulNums(4,5,6)
    val result4 = mulNums(4,5)
}

/*
Method Overloading allows us to multiple methods with the same name in the same scope
but with diff number of parameters or diff DataType
 */


// Different DT
fun sumNums(n1: Int, n2: Int): Int {
    println("Int Type Method was called")
    return n1 + n2
}
fun sumNums(n1: Double, n2: Double): Double {
    println("Double Type Method was called")
    return n1 + n2
}

// Different Number of args
fun mulNums(n1: Int, n2: Int, n3: Int): Int {
    println("Method with 3 args was called ")
    return (n1 * n2 * n3)
}

fun mulNums(n1: Int, n2: Int): Int {
    println("Method with 2 args was called ")
    return (n1 * n2)
}