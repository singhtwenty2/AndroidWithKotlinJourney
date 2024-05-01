package asynchronous_programming_03

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{ // Thread : main
    //Chapter 12 : CoroutineContext... : It can be inherited unlike CoroutineScope i.e,
//   Child coroutine can inherit CoroutineContext from its parent.

    /*    this : CoroutineScope instance.
          coroutineContext : CoroutineContext instance */

    // WITHOUT PARAMETER = CONFINED [CONFINED DISPATCHER] Like => launch { }
    launch { // Inherits the immediate coroutine as parent and gets its CoroutineContext
        println("C1 : ${Thread.currentThread().name}")
    }

    // WITH PARAMETER = Dispatchers.Default [Similar to GlobalScope.launch { } ]
    launch(Dispatchers.Default) { // Create a coroutine at Application level Similar to GlobalScope.launch { }
        println("C2 : ${Thread.currentThread().name}") // Thread T1 (let Say)
        delay(2000)
        println("C2 after delay : ${Thread.currentThread().name}") // Thread T1 or some other
    }

    // WITH PARAMETER = Dispatchers.Unconfined [UNCONFINED DISPATCHER]
    launch(Dispatchers.Unconfined) { // Same as without parameter but little different...
        println("C3 : ${Thread.currentThread().name}") // Thread main
        delay(1000)
        println("C3 after delay : ${Thread.currentThread().name}") // some other Thread but not the main let say T2

        launch(coroutineContext) { // Inherits the immediate parent...
            println("C4 : ${Thread.currentThread().name}") //Thread T2
            delay(1000)
            println("C4 after delay : ${Thread.currentThread().name}") //Thread T2
        }
    }

    println("Main Program...")
}