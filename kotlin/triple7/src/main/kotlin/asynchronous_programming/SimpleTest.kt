package asynchronous_programming

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class SimpleTest {

    @Test
    fun firstTest() = runBlocking{ // We can't directly call a suspend fun so that is why we used runBlocking here...
        myTestSuspendFunc()
        Assert.assertEquals(10,5+5)
    }
}