package com.example.tasks.demo.builder;

public class Main {
    public static void main(String[] args) {
        Cake cake = new Cake.CakeBuilder()
                .withAge(1)
                .withColor("blue")
                .withName("name")
                .build();
        System.out.println("cake = " + cake);
    }
}
