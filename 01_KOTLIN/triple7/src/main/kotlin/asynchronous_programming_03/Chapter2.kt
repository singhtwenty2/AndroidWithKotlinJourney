package asynchronous_programming_03

import kotlinx.coroutines.*

fun main() = runBlocking{ // Main Thread
    // Chapter 1 : Basic Intro With Coroutines...
    println("Main program starts here... : ${Thread.currentThread().name}")

    println("Main Thread is in progress...")
    //Creating a coroutine in a worker thread under main thread...
//    GlobalScope.launch { // Thread T1
//        println("Worker Thread is in progress... : ${Thread.currentThread().name}") // Thread T1
//        delay(500)  //Pretending to do some work... USING Thread.sleep() in a coroutine is not recommended
//        println("Worker Thread ends... : ${Thread.currentThread().name}") // Can be T1 or any other(Context Switching)
//    }
    val job: Job = launch { // Thread main(because launch is used : as launch is running in the scope of runBlocking which itself running in main thread )
        println("Worker Thread is in progress... : ${Thread.currentThread().name}") // Thread main
        delay(500)  //Pretending to do some work... USING Thread.sleep() in a coroutine is not recommended
        println("Worker Thread ends... : ${Thread.currentThread().name}") // Can be main or any other(Context Switching)
    }
    myFunc(1000)

    //This makes the main thread to wait for coroutine to finish(Not a good practice)
//    runBlocking { // Creates a coroutine & Blocks the main thread... However, there is a better approach to write this
//        delay(2000)
//    }
//    delay(2000) // Better approach to wait for coroutine to stop its job
    job.join() // It will wait for the coroutine to finish only after which the bellow code is executed

    println("Main program ends here... : ${Thread.currentThread().name}")
    //Here the main thread won't wait for the background coroutine to finish it will happen parallel
}

// User defined suspend function...
suspend fun myFunc(time: Long){
    delay(time)
    println("My Suspend Function is executed...")
}