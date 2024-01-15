package asynchronous_programming

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    //Chapter 11 : CoroutineScope : Every coroutine has its own coroutine scope irrespective of whether it is child or parent.
    println("runBlocking : $this")

    launch {
        println("launch : $this")

        launch {
            println("Child launch : $this")
        }
    }
    val result: Deferred<String> = async {
        println("async : $this")
        "Peter"
    }
}