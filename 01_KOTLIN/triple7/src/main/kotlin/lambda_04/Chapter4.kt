package lambda_04

// Types of ANON Funs
fun main() {
    // Type 1 : With para & return type
    val product = fun(a: Int, b: Int): Int {
        return (a * b)
    }
    println(product.invoke(4,16))
    // Type 2 : with para but no return type
    val prod2 = fun(a: Int , b: Int) {
        println(a * b)
    }
    prod2.invoke(5,5)
    // Type 3 : no para but return type
    val message = fun(): String {
        return "Welcome Everyone..."
    }
    println(message.invoke())
    // Type 4 : no para & no return type
    val mess = fun() {
        println("Welcome again...")
    }
    mess.invoke()
}