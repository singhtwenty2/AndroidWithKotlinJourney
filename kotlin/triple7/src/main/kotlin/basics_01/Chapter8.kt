package basics_01

fun main() {
    // Chapter 8... Filters and Map
    //Filter...
    val list1 = listOf<Int>(1,4,5,7,8,12,5,7)
    val result1 = list1.filter { /*When called with a predicate,
    filter() returns the collection elements that match it.*/
        it % 2 == 0
    }
    println(result1)
    //Map : It basically transform a list or a collection
    val list2 = listOf<Int>(1,2,3,4,5,6,7,8,9)
    list2.map {
        it*it
    }.forEach {
        println("$it")
    }
}