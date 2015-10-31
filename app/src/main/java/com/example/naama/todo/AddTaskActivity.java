package com.example.naama.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddTaskActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        intent= getIntent();
    }

    public void saveAndReturn(View view) {
        EditText item= (EditText) findViewById(R.id.addItemText);
        String newItem= item.getText().toString();
        intent.putExtra("KEY", newItem);
        setResult(RESULT_OK, intent);
        finish();
    }
}
