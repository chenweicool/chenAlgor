package com.chen.algor.ioc;


public class Person {

    private String name;

    private Integer age;


    private void setName(String name) {
        this.name = name;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    private String getName() {
        return name;
    }
    private Integer getAge() {
        return age;
    }
}
