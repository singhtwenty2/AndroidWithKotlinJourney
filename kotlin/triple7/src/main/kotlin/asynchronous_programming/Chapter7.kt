package asynchronous_programming

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() = runBlocking {
    // Chapter 7 : Timeouts...
    println("Main program starts... ${Thread.currentThread().name}")

    withTimeout(2000){
        try {
            for (i in 1..500){
                print("$i.")
                delay(50)
            }
        }
        catch (ex: TimeoutCancellationException){
            println("Exception caught...")
        }
        finally {
            // code..
        }
    }

    println("Main program ends... ${Thread.currentThread().name}")
}