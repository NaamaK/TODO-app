package com.example.naama.todo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TaskListActivity extends AppCompatActivity {

    private final ArrayList<String> itemArray = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemArray.add("1");
        itemArray.add("2");
        itemArray.add("3");
        itemArray.add("4");
        updateListView(itemArray);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {
            String itemName = data.getStringExtra("KEY");
            if (itemName == null) itemName = "NULL";
            itemArray.add(itemName);
            updateListView(itemArray);
        }
    }

    private void updateListView(ArrayList<String> itemArray) {
        ListView list = (ListView) findViewById(R.id.myListView);
        list.setAdapter(new MyListAdapter(itemArray));
    }

    public void addTask(View view) {
        Intent intent = new Intent(TaskListActivity.this, AddTaskActivity.class);     //activate the new activity
        startActivityForResult(intent, 1);                                            //initiate the activity
    }
}
