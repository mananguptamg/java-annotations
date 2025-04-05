package com.bridgelabz;

import java.util.ArrayList;

public class SuppressWarning {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList myList = new ArrayList();
        myList.add(22);
        myList.add("String");

        for(Object element : myList){
            System.out.println(element);
        }
    }
}
