package com.example.sqlshopsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

// code take from http://mobilesiri.com/android-sqlite-database-tutorial-using-android-studio/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler db = new DBHandler(this);

// Inserting Shop/Rows
        Log.d("Insert: ", "Inserting ..");
        db.addShop(new Shop("Dockers", " 475 Brannan St #330, San Francisco, CA 94107, United States"));
        db.addShop(new Shop("Dunkin Donuts", "White Plains, NY 10601"));
        db.addShop(new Shop("Pizza Porlar", "North West Avenue, Boston , USA"));
        db.addShop(new Shop("Town Bakers", "Beverly Hills, CA 90210, USA"));


        // Reading all shops
        Log.d("Reading: ", "Reading all shops after adding..");
        List<Shop> shops = db.getAllShops();

        for (Shop shop : shops) {
            String log = "Id: " + shop.getId() + " ,Name: " + shop.getName() + " ,Address: " + shop.getAddress();
        // Writing shops to log
            Log.d("Shop: : ", log);
        }

        // Deleting all shops
        for(int i = 1; i <=4; i++) db.deleteShop(db.getShop(i));


        // Reading all shops
        Log.d("Reading: ", "Reading all shops again after deleting..");
        shops = db.getAllShops();

        for (Shop shop : shops) {
            String log = "Id: " + shop.getId() + " ,Name: " + shop.getName() + " ,Address: " + shop.getAddress();
// Writing shops to log
            Log.d("Shop: : ", log);
        }
    }
}
