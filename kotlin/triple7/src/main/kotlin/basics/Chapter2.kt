package basics

fun main() {
    /* Chapter 2 Nullable Types...
In java sometimes we get Null Pointer Exception, To avoid it in
kotlin we have the concept of Nullable Types
    By default in Kotlin all variables are non-null However
    if we want to assign a null value to a variable we can use "?"
 */
// Defining a null value

    val myName: String? = null
    println(myName)
}