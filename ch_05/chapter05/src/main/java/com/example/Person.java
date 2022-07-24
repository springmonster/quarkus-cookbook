package com.example;

import javax.json.bind.annotation.JsonbProperty;

public class Person {

    private String name;
    private int age;

    @JsonbProperty("favorite_language")
    private String favoriteLanguage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
