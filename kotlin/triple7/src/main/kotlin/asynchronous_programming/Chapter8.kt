package asynchronous_programming

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    // Chapter 8 : Sequential Coroutines... : By default the coroutines are executed in sequence...
    println("Main program starts... ${Thread.currentThread().name}")
    val time = measureTimeMillis {
        val m1 = firstFunc()
        val m2 = secondFunc()
        println("$m1 $m2")
    }
    println("Elapsed Time : $time")
    println("Main program ends... ${Thread.currentThread().name}")
}

suspend fun firstFunc(): String{
    delay(1000)
    return "Hello"
}
suspend fun secondFunc(): String{
    delay(1000)
    return "World"
}