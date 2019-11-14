package com.example.tasks.demo.builder

class CakeForKotlin private constructor(cakeBuilder: CakeBuilder) {
    val age: Int = cakeBuilder.age
    val name: String? = cakeBuilder.name
    val color: String? = cakeBuilder.color

    override fun toString(): String {
        return "Cake(age=$age, name=$name, color=$color)"
    }

    data class CakeBuilder(
            var age: Int = 0,
            var name: String? = null,
            var color: String? = null) {

        fun withAge(age: Int) = apply { this.age = age }
        fun withName(name: String) = apply { this.name = name }
        fun withColor(color: String) = apply { this.color = color }
        fun build() =
            CakeForKotlin(this)

    }

}