package asynchronous_programming

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    // Chapter 9 : Concurrent Coroutines by using async...
    println("Main program starts... ${Thread.currentThread().name}")
    val time2 = measureTimeMillis {
        val m3: Deferred<String> = async { myFirstFunc() }
        val m4: Deferred<String> = async { mySecondFunc() }
        println("${m3.await()} ${m4.await()}")
    }
    println("Elapsed Time : $time2")
    println("Main program ends... ${Thread.currentThread().name}")
}
suspend fun myFirstFunc(): String{
    delay(1000)
    return "Hi"
}
suspend fun mySecondFunc(): String{
    delay(1000)
    return "There"
}