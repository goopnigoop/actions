package builder

fun main(args: Array<String>) {
    val cake = Cake.CakeBuilder()
            .withAge(1)
            .withColor("blue")
            .withName("name")
            .build()
    println(cake)
}