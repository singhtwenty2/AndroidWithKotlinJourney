package lambda_04

// Higher Order Functions
fun main() {
    /*
    Higher order funs : Accpets one or more functions as parameters & also can return
    a fun as a value it treats funs as first class objs.
     */
    val addResult = operateOnNumbers(
        a = 4,
        b = 6
    ) { x, y -> x + y }
    val subtractResult = operateOnNumbers(
        a = 4,
        b = 6
    ) {x , y -> x - y}
    val multiplyResult = operateOnNumbers(
        a = 4,
        b = 6
    ) {x , y -> x * y}
    println(addResult)
    println(subtractResult)
    println(multiplyResult)
}

fun operateOnNumbers(
    a: Int,
    b: Int,
    operation: (Int, Int) -> Int // A fun passed as a parameter
): Int {
    return operation(a, b)
}