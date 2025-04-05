package com.bridgelabz;

class LegacyAPI{
    @Deprecated
    void oldFeature(){
        System.out.println("This is old feature");
    }
    void newFeature(){
        System.out.println("This is new feature");
    }
}
public class DeprecatedMethod {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}
