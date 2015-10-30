package com.example.naama.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();
    }

    private void populateListView() {
        String[] itemArray= {"Homework", "Shopping", "Go to the doctor", "Wash my car", "Help Dana", "buy milk and sugar"};

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, R.layout.xml_item, itemArray);
        ListView list= (ListView)findViewById(R.id.myListView);
        list.setAdapter(adapter);

    }

    public void addTask(View view) {
        Intent intent= new Intent(this, AddTaskActivity.class);     //activate the new activity
        startActivity(intent);                                      //initiate the activity
    }
}
