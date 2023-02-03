package com.tejas.todoapp;

public class Model {

    private int id;
    private String tasks;

    public Model(int id, String tasks) {
        this.id = id;
        this.tasks = tasks;
    }

    public Model() {

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }


}
