package asynchronous_programming

import kotlinx.coroutines.delay

fun main() {
    // Chapter 4 : runBlocking -> It is mainly used to write test cases for coroutines...
}

suspend fun myTestSuspendFunc(){
    delay(2000) // Pretending as doing something...
}