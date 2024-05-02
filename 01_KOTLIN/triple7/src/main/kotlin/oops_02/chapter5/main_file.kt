package oops_02.chapter5

fun main() {
    val houseRobot = HouseRobot("Jarvis")
    val milateryRobot = MilateryRobot("FAUG")
    houseRobot.speak()
    houseRobot.cleanHouse()
    milateryRobot.speak()
    milateryRobot.fighting()
}