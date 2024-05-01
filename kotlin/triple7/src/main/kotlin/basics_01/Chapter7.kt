package basics_01

fun main(){
    // Chapter 7 Higher Order Functions...
    /* Higher order functions are those which can take a function as an arg and also it
    can return a function as a return value...
     */

    val output = operation(5, 7) { a, b ->
        println("Adding These two number...")
        a + b
    }
    println(output)
}
fun operation(a: Int, b: Int, operate: (Int, Int) -> Int) : Int{
    return operate(a,b)
}