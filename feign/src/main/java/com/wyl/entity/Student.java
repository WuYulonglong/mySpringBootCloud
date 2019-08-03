package com.wyl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

 /*   public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }*/
    private long id;
    private String name;
    private int age;
}
