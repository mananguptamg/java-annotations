package com.bridgelabz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "Medium";
}

class Assignment{
    @Todo(task = "Frontend Development", assignedTo = "Manan")
    public void frontend(){
        System.out.println("Frontend development");
    }

    @Todo(task = "Backend Development", assignedTo = "Ayush", priority = "Low")
    public void backend(){
        System.out.println("Backend development");
    }

    @Todo(task = "Project Deployment", assignedTo = "Aman", priority = "High")
    public void deploy(){
        System.out.println("Project Deployment");
    }
}
public class TodoAnnotation {
    public static void main(String[] args) {
        Assignment java = new Assignment();
        Class<?> cls = java.getClass();

        Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods){
            Todo todo = method.getAnnotation(Todo.class);
            System.out.print("Task name: " +todo.task()+" ");
            System.out.print("Assigned to: " +todo.assignedTo()+" ");
            System.out.println("Priority: " +todo.priority());
            System.out.println("-----------------------------------------------");
        }
    }
}
