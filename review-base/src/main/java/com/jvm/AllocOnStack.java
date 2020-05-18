package com.jvm;

public class AllocOnStack {
    static class User{
        Long id;
        String name;
    }
    private static User u;
    private static void alloc() {
        User u = new User();
        u.id = 5L;
        u.name = "geym";
    }
    public static void main(String[] args) {
        long b = System.currentTimeMillis();

        for (long i = 0; i < 1000000000L; i++) {
            alloc();
        }

        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }
}
