package com.DesignPatterns.Builder;

public class UserService {
    public static void main(String[] args) {
        User u = new User.Builder().name("Liki").age(26).email("liki@gmail.com").build();

        System.out.println(u.toString());
    }
}
