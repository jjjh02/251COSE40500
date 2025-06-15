package org.example;

public class 람다식 {
    public static void main(String[] args) {
        Runnable r2 = () -> System.out.println("Hello, World!");
        r2.run();
    }
}
