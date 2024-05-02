package oops_02.chapter5

open class Robot(
    val name: String
) {
    fun walk() {
        println("The Robot is walking...")
    }
    fun speak() {
        println("$name can speak...")
    }
}

/*
Open Keyword allows other class which inherits from this parent class to override the
methods.
 */