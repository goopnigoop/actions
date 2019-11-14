package com.example.tasks.demo.builder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CakeTest {

    private final int age = 13;
    private final String color = "blue";
    private final String name = "name";


    @Test
    public void shouldCreateCakeFromBuilder() {
        // GIVEN
        Cake cake = new Cake.CakeBuilder()
                .withAge(age)
                .withColor(color)
                .withName(name)
                .build();

        assertThat(cake.age)
                .isEqualTo(age);
        assertThat(cake)
                .isInstanceOf(Cake.class);


    }

}