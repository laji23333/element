package com.element.Entity;

public class User {
    private int userId;
    private String userName;
    private int age;
    private int countryId;

    public User(int userId, String userName, int age, int countryId) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.countryId = countryId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public int getCountryId() {
        return countryId;
    }
}

