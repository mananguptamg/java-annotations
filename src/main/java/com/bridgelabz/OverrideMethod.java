package com.bridgelabz;

class Animal{
    public void makeSound() {
        System.out.println("Animals make sound");
    }
}
class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class OverrideMethod {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();
    }
}
