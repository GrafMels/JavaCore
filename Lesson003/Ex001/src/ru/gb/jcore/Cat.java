package ru.gb.jcore;

public class Cat {
    String name;
    String color;
    int age;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    void jump(){
        if (age < 5){
            System.out.println(name + " jump");
        }
    }

    void voice(){
        System.out.println(name + " voice");
    }
}
