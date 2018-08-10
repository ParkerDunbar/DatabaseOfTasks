package com.example.sqlshopsdemo;

import android.content.Context;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Task> {

    private Chronometer chronometer;
    private long pauseOffSet = 0;
    private boolean isRunning = false;

    public CustomAdapter(Context context, List<Task> tasks) {
        super(context, R.layout.task_custom, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.task_custom, parent, false);
        chronometer = (Chronometer) customView.findViewById(R.id.task_time);

        final Task singleTask = getItem(position);
        TextView taskName = (TextView) customView.findViewById(R.id.task_name);
        TextView taskTime = (TextView) customView.findViewById(R.id.task_time);

        Button startButton = (Button) customView.findViewById(R.id.task_start);
        Button stopButton = (Button) customView.findViewById(R.id.task_pause);
        Button completeButton = (Button) customView.findViewById(R.id.task_complete);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stop();
            }
        });

        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        taskName.setText(singleTask.getTask());
        taskTime.setText(singleTask.getTime());
        return customView;
    }

    public Chronometer getChronometer() {
        return chronometer;
    }
    public void setChronometer(Chronometer chronometer) {
        this.chronometer = chronometer;
    }
    public long getPauseOffSet() {
        return pauseOffSet;
    }
    public void setPauseOffSet(long pauseOffSet) {
        this.pauseOffSet = pauseOffSet;
    }


    public void Start() {
        if(!isRunning){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffSet);
            chronometer.start();
            isRunning = true;
        }
    }
    public void Stop() {
        if(isRunning){
            chronometer.stop();
            pauseOffSet = SystemClock.elapsedRealtime() - chronometer.getBase();
            isRunning = false;
        }
    }

}
