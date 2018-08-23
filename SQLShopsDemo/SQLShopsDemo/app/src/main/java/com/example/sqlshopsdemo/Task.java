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
    private TaskObject taskObject = new TaskObject();
    private Chronometer taskTime;
    private long pauseOffSet = 0;
    private boolean isRunning = false;


    public Task() {

    }


    public Task(TaskObject taskObject, View v) {
        this.taskObject = taskObject;
        this.taskTime = (Chronometer) v;
    }

    public Task(String task, String time) {
        this.taskObject.setTask(task);
        this.taskObject.setTime(time);
    }



    public void setTask(String task) {
        this.taskObject.setTask(task);
    }

    public void setTime(String time) {
        this.taskObject.setTime(time);
        pauseOffSet = Long.parseLong(time);
    }

    public int getId() {
        return taskObject.getId();
    }

    public String getTime() {
        return taskObject.getTime();
    }

    public String getTask() {
        return taskObject.getTask();
    }


    public Chronometer getTaskTime() {
        taskTime.setBase(SystemClock.elapsedRealtime() - pauseOffSet);
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
            taskObject.setTime(pauseOffSet + "");
        }
    }


}