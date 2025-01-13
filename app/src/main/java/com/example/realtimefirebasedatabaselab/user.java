package com.example.realtimefirebasedatabaselab;

public class user {
    private String name,email,pass,age,phone;

    public user(String name, String pass, String email, String age, String phone) {
        this.name = name;
        this.pass = pass;
        this.email = email;
        this.age = age;
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
