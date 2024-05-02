package oops_02.chapter5

class HouseRobot(name: String): Robot(name) {
    fun cleanHouse() {
        println("$name is cleaning the house...")
    }
}