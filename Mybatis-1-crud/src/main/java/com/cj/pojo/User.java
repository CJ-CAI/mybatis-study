package com.cj.pojo;


public class User {

    private String name;
    private int id;
    private int age;
    private int k_value;
    public User(){}

    public User(int id,  String name,int age, int k_value) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.k_value = k_value;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", k_value=" + k_value +
                '}';
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setK_value(int k_value) {
        this.k_value = k_value;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getK_value() {
        return k_value;
    }

}
