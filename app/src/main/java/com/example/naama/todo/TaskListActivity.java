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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TaskListActivity extends AppCompatActivity {

    private final ArrayList<String> itemArray= new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemArray.add("1");
        itemArray.add("2");
        itemArray.add("3");
        itemArray.add("4");

        ListView list= (ListView)findViewById(R.id.myListView);
        list.setAdapter(new MyListAdapter(this, R.layout.xml_item, itemArray));
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
    }

    public void addTask(View view) {
        Intent intent= new Intent(TaskListActivity.this, AddTaskActivity.class);     //activate the new activity
        startActivityForResult(intent,1);                                            //initiate the activity
    }

    private class MyListAdapter extends ArrayAdapter<String> {

        private int layout;

        public MyListAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            layout= resource;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainHolder= null;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView= inflater.inflate(layout, parent, false);
                ViewHolder viewHolder= new ViewHolder();
                viewHolder.item= (TextView) convertView.findViewById(R.id.itemText);
                viewHolder.btn= (Button) convertView.findViewById(R.id.doneBtn);
                viewHolder.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), itemArray.get(position), Toast.LENGTH_SHORT).show();
                    }
                });
                convertView.setTag(viewHolder);
            }
            else {
                mainHolder= (ViewHolder) convertView.getTag();
                mainHolder.item.setText(getItem(position));
            }

            return convertView;
        }

        public class ViewHolder {
            TextView item;
            Button btn;
        }
    }
}