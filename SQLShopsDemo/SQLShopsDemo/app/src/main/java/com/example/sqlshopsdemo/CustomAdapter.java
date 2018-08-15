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
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Task> {

    //    private Chronometer chronometer;
    private Context context;
    ViewHolder holder;

    public CustomAdapter(Context context, List<Task> tasks) {
        super(context, R.layout.task_custom, tasks);
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.task_custom, null, true);

            holder.task = getItem(position);
            holder.task_name = (TextView) convertView.findViewById(R.id.task_name);
            holder.task.setTaskTime((Chronometer) convertView.findViewById(R.id.task_time));
            holder.btn_start = (Button) convertView.findViewById(R.id.task_start);
            holder.btn_stop = (Button) convertView.findViewById(R.id.task_pause);
            holder.btn_complete = (Button) convertView.findViewById(R.id.task_complete);


            convertView.setTag(holder);
        } else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder) convertView.getTag();
        }

        holder.task_name.setText(getItem(position).getTask());
        holder.task.setTaskTime((getItem(position).getTaskTime()));

        holder.btn_start.setTag(R.integer.btn_start_view, convertView);
        holder.btn_start.setTag(R.integer.btn_start_pos, position);
        holder.btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getItem(position).Start();

            }
        });


        holder.btn_stop.setTag(R.integer.btn_stop_pos, position);
        holder.btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getItem(position).Stop();
            }
        });

        holder.btn_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.taskList.remove(getItem(position));
                MainActivity.adapter = new CustomAdapter(context, MainActivity.taskList);
                MainActivity.listView.setAdapter(MainActivity.adapter);
            }
        });

        return convertView;
    }


    private class ViewHolder {
        protected Button btn_start, btn_stop, btn_complete;
        private TextView task_name;
        public Task task = new Task();
    }


}