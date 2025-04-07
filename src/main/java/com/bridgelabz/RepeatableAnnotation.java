package com.bridgelabz;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Bugs.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Bugs {
    BugReport [] value();
}

@BugReport(description = "Server crashed")
@BugReport(description = "Screenshot capture failed")
class App{
}

public class RepeatableAnnotation {
    public static void main(String[] args) {
        BugReport [] bugArray = App.class.getAnnotationsByType(BugReport.class);
        for(BugReport bugs: bugArray){
            System.out.println(bugs.description());
        }
    }
}
