package asynchronous_programming_03

import kotlinx.coroutines.*

fun main() = runBlocking {
    // Chapter 6 : Exceptions Handling in Cancellation...
    println("Main program starts... ${Thread.currentThread().name}")
    val job: Job = launch {
        try {
            for(i in 1..100){
                println("$i.")
                delay(50)
            }
        }
        catch (ex: CancellationException){
            println("Exception caught...: ${ex.message}")
        }
        finally {
            withContext(NonCancellable){
                delay(500) // Directly we can't use suspending functions inside finally
                println("Resources closed...")
            }
        }
    }
    delay(1000)
    job.cancel(CancellationException("My own crash message."))
    println("Main program ends... ${Thread.currentThread().name}")
}