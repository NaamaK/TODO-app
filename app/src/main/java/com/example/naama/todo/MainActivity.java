package com.example.naama.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private final Vector<String> itemArray= new Vector<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1) {
            String itemName= data.getStringExtra("KEY");
            if (itemName==null) itemName="NULL";
            populateListView(itemName);
        }
    }

    private void populateListView(String str) {
        itemArray.add(str);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, R.layout.xml_item, itemArray);
        ListView list= (ListView)findViewById(R.id.myListView);
        list.setAdapter(adapter);
    }

    public void addTask(View view) {
        Intent intent= new Intent(MainActivity.this, AddTaskActivity.class);     //activate the new activity
        startActivityForResult(intent,1);                                        //initiate the activity
    }
}
