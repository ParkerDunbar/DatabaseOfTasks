package com.example.sqlshopsdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Task> {

    public CustomAdapter(Context context, List<Task> tasks) {
        super(context, R.layout.task_custom, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.task_custom, parent, false);

        final Task singleTask = getItem(position);
        TextView taskName = (TextView) customView.findViewById(R.id.task_name);
        TextView taskTime = (TextView) customView.findViewById(R.id.task_time);

        Button startButton = (Button) customView.findViewById(R.id.task_start);
        Button stopButton = (Button) customView.findViewById(R.id.task_pause);
        Button completeButton = (Button) customView.findViewById(R.id.task_complete);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singleTask.Start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                singleTask.Stop();
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
}
