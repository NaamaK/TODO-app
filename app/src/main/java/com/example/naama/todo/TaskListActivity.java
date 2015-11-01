package com.example.naama.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {

    private final ArrayList<String> itemArray = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemArray.add("Homework");
        itemArray.add("Shopping");
        itemArray.add("Clean my room");
        itemArray.add("Wash my car");
        itemArray.add("Go visit Bob");
        itemArray.add("Call Rona");
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
