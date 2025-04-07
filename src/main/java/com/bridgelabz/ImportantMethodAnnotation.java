package com.bridgelabz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "Medium";
}

class Task{
    @ImportantMethod()
    public void printing(){
        System.out.println("Printing ");
    }
    @ImportantMethod(level = "High")
    public void networking(){
        System.out.println("Networking");
    }

}

public class ImportantMethodAnnotation {
    public static void main(String[] args) {
        Task task = new Task();
        Class<?> cls = task.getClass();

        Method[] methods = cls.getDeclaredMethods();

        for(Method method : methods){
            ImportantMethod importantMethod = method.getAnnotation(ImportantMethod.class);
            System.out.print("Method " +method.getName());
            System.out.println(" Priority " +importantMethod.level());
            
        }
    }
}
