package com.bridgelabz;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
    // Optional attributes with default values
    String message() default "Method executed in: ";
}

class Service{
    @LogExecutionTime(message = "Time taken for processing data: ")
    public void processData(){
    }

    @LogExecutionTime(message = "Time taken for uploading data: ")
    public void uploadData(){
    }
}

public class LogExecutionTimeAnnotation {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Service service = new Service();
        Class<?> cls = service.getClass();

        Method[] methods = cls.getDeclaredMethods();

        for(Method method : methods){
            LogExecutionTime time = method.getAnnotation(LogExecutionTime.class);
            long startTime = System.nanoTime();
            method.invoke(service);
            long endTime = System.nanoTime();
            System.out.println(time.message()+(endTime-startTime)+" ns");
        }
    }
}
