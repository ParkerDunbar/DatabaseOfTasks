package com.example.sqlshopsdemo;

public class TaskObject {
    private int id;
    private String task;
    private String time = "0";

    public TaskObject() {}

    public TaskObject(int id, String task, String time) {
        this.id = id;
        this.task = task;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return this.id + " " + this.task + " " + this.time;
    }
}
