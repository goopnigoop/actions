package com.example.tasks.demo.builder;

public class Main {
    public static void main(String[] args) {
        CakeForKotlin cakeForKotlin = new CakeForKotlin.CakeBuilder()
                .withAge(1)
                .withColor("blue")
                .withName("name")
                .build();
        System.out.println("cake = " + cakeForKotlin);
    }
}
