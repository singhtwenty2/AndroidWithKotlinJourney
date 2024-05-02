package lambda_04

/* Anonymous Functions
The main diff b/w anon func and lambda fun is anon fun doesn't have a name and it
explicitly contains "return"
 */
fun main() {
    // Syntax of ANON Fun
  //val var_name: (DT1, DT2) -> ReturnType = fun(para1, para2): ReturnType {method_body}
    val add4: (Int, Int) -> Int = fun(a, b): Int { return (a + b)}
    println(add4(3,6))
    // A shorter syntax
  //val var_name = fun(para1: DT1, para2: DT2): ReturnType {method_body}
    // An anon fun to cal the square
    val numbers = listOf(1,2,3,4,5)
    val squareOf = fun(x: Int): Int {
        return (x * x)
    }
    val squaredNumbers = numbers.map(squareOf)
    println(squaredNumbers)

}