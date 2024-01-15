package little_advanced

fun main(){
    // Chapter 1 Classes and Objects...
    val p1 = Person("Aryan")
    println(p1.name)
    val p2 = DiffrentPerson("Aryan")
    println(p2.name)
}

class Person(_name: String){ // This is a lot easier syntax then java however we can make it more simple
    val name: String // _name is the arg supplied while constructing the obj of the class and name is the property of the class
    init {
        name = _name
    }
}

class DiffrentPerson(val name: String) // by putting val in the arg of class it now becomes the property of the class