package com.zzuli.home.model;

public class User {

    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private String userName;
    private String password;
    private String role;
    private int is_delete;
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getIs_delete() {
        return is_delete;
    }
    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
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
}
