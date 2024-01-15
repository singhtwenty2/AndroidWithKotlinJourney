package asynchronous_programming

import kotlin.concurrent.thread

fun main() { // Main Thread
    // Chapter 1 : Coroutines are not Thread...
    println("Main program starts here... : ${Thread.currentThread().name}")

    println("Main Thread is in progress...")
    //Creating a worker thread under main thread...
    thread {
        println("Worker Thread is in progress... : ${Thread.currentThread().name}")
        Thread.sleep(500)  //Pretending to do some work...
        println("Worker Thread ends... : ${Thread.currentThread().name}")
    }

    println("Main program ends here... : ${Thread.currentThread().name}")
}