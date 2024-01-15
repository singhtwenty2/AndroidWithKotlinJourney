package asynchronous_programming

import kotlinx.coroutines.*

fun main() = runBlocking {
    // Chapter 10 : LAZY basically when we don't want to run a coroutine in case like when the result from the coroutine is not being used
    println("Main program starts... ${Thread.currentThread().name}")

    val m5: Deferred<String> = async(start = CoroutineStart.LAZY) { myFirstFunction() }
    val m6: Deferred<String> = async(start = CoroutineStart.LAZY) { mySecondFunction() }
//    println("${m5.await()} ${m6.await()}")
    // As the values m5 and m6 which we received from both sus func are not in use. Hence, both sus func are not exec.

    println("Main program ends... ${Thread.currentThread().name}")
}

suspend fun myFirstFunction(): String{
    delay(1000)
    println("Suspend Func 1 Executed")
    return "Hi"
}
suspend fun mySecondFunction(): String{
    delay(1000)
    println("Suspend Func 2 Executed")
    return "There"
}