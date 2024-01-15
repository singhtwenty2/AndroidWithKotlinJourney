package asynchronous_programming

import kotlinx.coroutines.*

fun main() = runBlocking {
    // Chapter 5 : Cooperative coroutine
    println("Main program starts... ${Thread.currentThread().name}")

    val job: Job = launch {// Non Blocking and Cooperative coroutine...
        for(i in 1..100){
            println("$i.")
//            Thread.sleep(50) // Intentionally creating delay. So that we can cancel the coroutine
            delay(50) // Now it is a Cooperative coroutine...
        }
    }
    delay(2000)
    job.cancelAndJoin() // As it is taking too long we want to cancel the coroutine but only after 2000mS
    println("Main program ends... ${Thread.currentThread().name}")
}