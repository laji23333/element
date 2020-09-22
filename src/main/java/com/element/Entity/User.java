package com.element.Entity;

public class User {
    private String userId;
    private String userName;
    private String password;
    private int userSex;
    private String userImg;
    private int delTag;

    public String getUserID() {
        return userId;
    }
    public void setUserID(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getUserSex() {
        return userSex;
    }
    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }
    public String getUserImg() {
        return userImg;
    }
    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }
    public int getDelTag() {
        return delTag;
    }
    public void setDelTag(int delTag) {
        this.delTag = delTag;
    }
}
