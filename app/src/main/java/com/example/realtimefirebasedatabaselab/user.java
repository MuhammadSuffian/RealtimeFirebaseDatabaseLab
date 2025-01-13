package com.example.realtimefirebasedatabaselab;

public class user {
    private String name,email,pass,age,phone;
    user(){

    }
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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }
}
