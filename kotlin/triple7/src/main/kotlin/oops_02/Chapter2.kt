package oops_02

fun main() {
    // Chapter 2... Spacial Classes like Data Class and ETC...
    val p1 = User("Rishabh",21)
    val doppelganger = User("Rishabh",21)
    val p3 = User("Ranjan",20)

    println(p1)
    println(p3)
    println("p1 == doppelganger : ${p1==doppelganger}")
    println("p3 == doppelganger : ${p3==doppelganger}")
    /*  In Kotlin == checks the values stored in the two variable we can implement this functionality
        in kotlin because of data class same functionality in java can be implemented by using
        hashcode() and equals() */

    println("p1 === doppelganger : ${p1===doppelganger}") // === checks for the same references in the memory as same as what we have in JS
    // hashcode() function
    println(p1.hashCode())
    // copy() function
    val p4 = p1.copy(name = "Alex")
    println(p4)
}
// Data class for holding simple data with auto-generated methods
data class User(val name: String, var age: Int)