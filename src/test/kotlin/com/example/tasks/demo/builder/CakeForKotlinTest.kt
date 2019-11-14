package com.example.tasks.demo.builder

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CakeForKotlinTest{
    private val age: Int = 13;
    private val color: String = "blue";
    private val name: String = "name";

    @Test
    fun `should create cake from builder`() {
        // GIVEN
        val cake = CakeForKotlin.CakeBuilder()
                .withAge(age)
                .withColor(color)
                .withName(name)
                .build()

        assertThat(cake)
                .isExactlyInstanceOf(CakeForKotlin::class.java)
        assertThat(cake.name)
                .isEqualTo(name)


    }
}

