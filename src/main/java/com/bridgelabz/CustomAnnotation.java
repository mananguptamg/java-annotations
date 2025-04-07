package com.bridgelabz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager{
    public void codeWritten(){
        System.out.println("Code is successfully written.");
    }
    @TaskInfo(priority = "High", assignedTo = "Manan")
    public void codePushedToGit(){
        System.out.println("Code successfully pushed to git.");
    }
}
public class CustomAnnotation {
    public static void main(String[] args) {
        TaskManager task = new TaskManager();
        Class<?> cls = task.getClass();

        for(Method method : cls.getDeclaredMethods()){
            if(method.isAnnotationPresent(TaskInfo.class)){
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }
        }
    }
}
