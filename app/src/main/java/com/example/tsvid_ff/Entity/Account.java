package com.example.tsvid_ff.Entity;

public class Account {
    private String id, password,datetime, name, faculty, classroom, scholastic, image;
    private String permission;

    public Account(String id, String password, String datetime, String name, String faculty, String classroom, String scholastic, String permission, String image) {
        this.id = id;
        this.password = password;
        this.datetime = datetime;
        this.name = name;
        this.faculty = faculty;
        this.classroom = classroom;
        this.scholastic = scholastic;
        this.image = image;
        this.permission = permission;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getScholastic() {
        return scholastic;
    }

    public void setScholastic(String scholastic) {
        this.scholastic = scholastic;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Account(){

    }
}
