package asynchronous_programming_03

import kotlinx.coroutines.*

fun main() = runBlocking {
    // Chapter 3 : Async coroutine Builder...
    println("Main program starts here... : ${Thread.currentThread().name}")

    val jobDeferred: Deferred<Int> = async {// Difference b/w this & and launch is async return a Deferred Object which is of type generic
        println("Worker Thread is in progress... : ${Thread.currentThread().name}")
        delay(500) // Pretend to do some work
        println("Worker Thread ends... : ${Thread.currentThread().name}")
        15
    }
    val num: Int = jobDeferred.await() // the value 15 which is returned by the above coroutine is being fetched by using await
    println(num)
//    jobDeferred.join()
    println("Main program ends here... : ${Thread.currentThread().name}")
}