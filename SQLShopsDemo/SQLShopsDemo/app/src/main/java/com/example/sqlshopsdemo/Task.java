package com.example.sqlshopsdemo;

import java.sql.Time;
import java.util.Timer;

public class Task {
    private int id;
    private String task;
    private String time;
    public Task()
    {
    }
    public Task(int id, String task, String time)
    {
        this.id = id;
        this.task = task;
        this.time = time;
    }
    public Task(String task, String time)
    {
        this.task = task;
        this.time = time;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTask(String task) {
        this.task = task;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public int getId() {
        return id;
    }
    public String getTime() {
        return time;
    }
    public String getTask() {
        return task;
    }
}