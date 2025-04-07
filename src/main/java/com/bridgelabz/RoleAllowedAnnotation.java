package com.bridgelabz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Scanner;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface RoleAllowed{
    String role();
}

@RoleAllowed(role = "Admin")
class Admin{
    public void createUser(){
        System.out.println("New users created successfully");
    }
}

public class RoleAllowedAnnotation {
    public static void main(String[] args) {
        // Use try-catch to handle exceptions
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter role: ");
            String role = scanner.next();

            Class<?> cls = Admin.class;

            if(cls.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed annotation = cls.getAnnotation(RoleAllowed.class);
                if(!annotation.role().equalsIgnoreCase(role)) {
                    throw new IllegalArgumentException("Access Denied!");
                }
            }

            Method[] methods = cls.getDeclaredMethods();
            for(Method method:methods) {
                method.invoke((Admin)cls.getDeclaredConstructor().newInstance());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
