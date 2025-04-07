package com.bridgelabz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength{
    int value();
}

class User{
    @MaxLength(value = 10)
    public String username;
    public int age;
    User(String username, int age) {
        this.username = username;
        this.age = age;
    }
    public void displayDetails() {
        System.out.println("User registered successfully!!");
        System.out.println("Username: " + username);
        System.out.println("Age: " + age);
    }
}

public class MaxLengthAnnotation {
    public static void main(String[] args) throws IllegalAccessException {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter username: ");
            String username = scanner.next();

            System.out.print("Enter age: ");
            int age = scanner.nextInt();

            User user = new User(username,age);
            Class<?> cls = user.getClass();

            Field[] fields = cls.getDeclaredFields();

            for(Field userField : fields) {
                if(userField.isAnnotationPresent(MaxLength.class)) {
                    MaxLength annotation = userField.getAnnotation(MaxLength.class);
                    if(userField.get(user).toString().length()>annotation.value()) {
                        throw new IllegalArgumentException("Username must be less than 8 characters.");
                    }
                }
            }
            user.displayDetails();
        }catch (IllegalArgumentException e){
            System.out.println("Illegal Argument Exception " +e.getMessage());
        }
    }
}
