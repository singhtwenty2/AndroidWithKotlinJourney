package basics

fun main() {
    // Chapter 5 Collection Framework

    val carModelsArray = arrayOf("S-Class", "E-Class", "C-Class", "A-Class")
    for (cars in carModelsArray) {
        println(cars)
    }
    carModelsArray[1] = "Maybach" // Array are Mutable...
    println(carModelsArray[1])

    // Lists Non_Mutable Collection of element of different DT
    val carModelsList = listOf("AMG-S-Class", "AMG-E-Class", "AMG-C-Class", 320)
    for (cars in carModelsList) {
        println(cars)
    }
//    carModelsList[1] = "GLS"
//    println(carModelsList[1]) It can't be changed as list are by-default Non-Mutable
//    if we want to make them mutable then we have to use mutableListOf()

    // Sets same as sets in Mathematics... Ordered pair of elements...
    val stringSet = setOf("one", "two", "three")
    println(stringSet)

    // Maps same as dict. in python...
    val numbersMap = mapOf(
        "key1" to 1,
        "key2" to 2,
        "key3" to 3,
        "key4" to 1
    )

    println(numbersMap)

    println("All keys: ${numbersMap.keys}")
    println("All values: ${numbersMap.values}")
}