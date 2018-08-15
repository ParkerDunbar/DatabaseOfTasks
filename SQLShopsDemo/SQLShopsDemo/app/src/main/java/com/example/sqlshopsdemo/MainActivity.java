package com.example.sqlshopsdemo;

import android.app.Activity;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.app.AlertDialog;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

// code take from http://mobilesiri.com/android-sqlite-database-tutorial-using-android-studio/


public class MainActivity extends Activity {
    ListAdapter adapter;
    ListView listView;
    public static List<Task> taskList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Task t1 = new Task("Task1", "0");
//        Task t2 = new Task("Task4", "4232");
//        Task t3 = new Task("Task7", "215145");
//        taskList.add(t1);
//        taskList.add(t2);
//        taskList.add(t3);

        adapter = new CustomAdapter(this, taskList);
        listView = (ListView) findViewById(R.id.task_list);
        listView.setAdapter(adapter);
    }

    public void addTask(final View view) {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(this);
        final View promptsView = li.inflate(R.layout.custom, null);

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView.findViewById(R.id.editTextDialogUserInput);
        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
                                String taskName = userInput.getText().toString();
//                                Task newTask = new Task(task, 0 + "");
                                Task newTask = new Task(taskList.size(), taskName, "0", findViewById(R.id.task_time));
                                taskList.add(newTask);
//                                listItems.add(task);
//                                adapter.notifyDataSetChanged();
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }
}




//        DBHandler db = new DBHandler(this);
//
//// Inserting Shop/Rows
//        Log.d("Insert: ", "Inserting ..");
//        db.addShop(new Shop("Dockers", " 475 Brannan St #330, San Francisco, CA 94107, United States"));
//        db.addShop(new Shop("Dunkin Donuts", "White Plains, NY 10601"));
//        db.addShop(new Shop("Pizza Porlar", "North West Avenue, Boston , USA"));
//        db.addShop(new Shop("Town Bakers", "Beverly Hills, CA 90210, USA"));
//
//
//        // Reading all shops
//        Log.d("Reading: ", "Reading all shops after adding..");
//        List<Shop> shops = db.getAllShops();
//
//        for (Shop shop : shops) {
//            String log = "Id: " + shop.getId() + " ,Name: " + shop.getName() + " ,Address: " + shop.getAddress();
//        // Writing shops to log
//            Log.d("Shop: : ", log);
//        }
//
//        // Deleting all shops
//        for(int i = 1; i <=4; i++) db.deleteShop(db.getShop(i));
//
//
//        // Reading all shops
//        Log.d("Reading: ", "Reading all shops again after deleting..");
//        shops = db.getAllShops();
//
//        for (Shop shop : shops) {
//            String log = "Id: " + shop.getId() + " ,Name: " + shop.getName() + " ,Address: " + shop.getAddress();
//// Writing shops to log
//            Log.d("Shop: : ", log);
//        }