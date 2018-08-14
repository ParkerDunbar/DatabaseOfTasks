package com.example.sqlshopsdemo;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Task> {

    private Chronometer chronometer;
    private boolean isRunning = false;
    private Context context;
    ViewHolder holder;

    public CustomAdapter(Context context, List<Task> tasks) {
        super(context, R.layout.task_custom, tasks);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            holder = new ViewHolder(); LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.task_custom, null, true);

            holder.task_name = (TextView) convertView.findViewById(R.id.task_name);
            holder.task_time = (Chronometer) convertView.findViewById(R.id.task_time);
            holder.btn_start = (Button) convertView.findViewById(R.id.task_start);
            holder.btn_stop = (Button) convertView.findViewById(R.id.task_pause);
            holder.btn_complete = (Button) convertView.findViewById(R.id.task_complete);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.task_name.setText(getItem(position).getTask());
        holder.task_time.setText(getItem(position).getTime());

        holder.btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Start(holder.task_time);
            }
        });
        holder.btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stop(holder.task_time);
            }
        });



//        LayoutInflater inflater = LayoutInflater.from(getContext());
//        View customView = inflater.inflate(R.layout.task_custom, parent, false);
//        chronometer = (Chronometer) customView.findViewById(R.id.task_time);
//
//        final Task singleTask = getItem(position);
//        TextView taskName = (TextView) customView.findViewById(R.id.task_name);
//        Chronometer taskTime = (Chronometer) customView.findViewById(R.id.task_time);
//
//        Button startButton = (Button) customView.findViewById(R.id.task_start);
//        Button stopButton = (Button) customView.findViewById(R.id.task_pause);
//        Button completeButton = (Button) customView.findViewById(R.id.task_complete);
//
//        startButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Start();
//            }
//        });
//
//        stopButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Stop();
//            }
//        });
//
//        completeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
//        taskName.setText(singleTask.getTask());
//        taskTime.setText(singleTask.getTime());
        return convertView;
    }

    public Chronometer getChronometer() {
        return chronometer;
    }
    public void setChronometer(Chronometer chronometer) {
        this.chronometer = chronometer;
    }

    public void Start(Chronometer chronometer) {
        if(!isRunning){
            chronometer.setBase(SystemClock.elapsedRealtime() - holder.task.getPauseOffSet());
            chronometer.start();
            isRunning = true;
        }
    }
    public void Stop(Chronometer chronometer) {
        if(isRunning){
            chronometer.stop();
            holder.task.setPauseOffSet(SystemClock.elapsedRealtime() - chronometer.getBase());
            isRunning = false;
        }
    }

    private class ViewHolder {
        protected Button btn_start, btn_stop, btn_complete;
        private TextView task_name;
        private Chronometer task_time;
        private Task task = new Task();
    }


}
