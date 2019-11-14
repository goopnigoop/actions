package com.example.tasks.demo.builder;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Cake {
    int age;
    String name;
    String color;

    private Cake(CakeBuilder cakeBuilder) {
        this.age = cakeBuilder.age;
        this.name = cakeBuilder.name;
        this.color = cakeBuilder.color;
    }

    public static class CakeBuilder {
        int age;
        String name;
        String color;

        CakeBuilder withAge(int age){
            this.age = age;
            return this;
        }

        CakeBuilder withName(String name){
            this.name = name;
            return this;
        }

        CakeBuilder withColor(String color){
            this.color = color;
            return this;
        }

        public Cake build(){
            return new Cake(this);
        }
    }
}
