package com.example.sqlshopsdemo;

import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.sql.Time;
import java.util.Timer;

public class Task {
    private int id;
    private String task;
    private String time;
    private Chronometer taskTime;
    private long pauseOffSet = 0;
    private boolean isRunning = false;


    public Task() {

    }

    public Task(int id, String task, String time) {
        this.id = id;
        this.task = task;
        this.time = time;
    }

    public Task(int id, String task, String time, View v) {
        this.id = id;
        this.task = task;
        this.time = time;
        this.taskTime = (Chronometer) v;
    }

    public Task(String task, String time) {
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

    public long getPauseOffSet() {
        return pauseOffSet;
    }

    public void setPauseOffSet(long pauseOffSet) {
        this.pauseOffSet = pauseOffSet;
    }

    public Chronometer getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(Chronometer taskTime) {
        this.taskTime = taskTime;
    }

    public void Start() {
        if (!isRunning) {
            taskTime.setBase(SystemClock.elapsedRealtime() - pauseOffSet);
            taskTime.start();
            isRunning = true;
        }
    }

    public void Stop() {
        if (isRunning) {
            taskTime.stop();
            pauseOffSet = SystemClock.elapsedRealtime() - taskTime.getBase();
            isRunning = false;
        }
    }


}