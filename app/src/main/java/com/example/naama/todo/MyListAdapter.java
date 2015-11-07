package com.example.naama.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Naama on 01/11/2015.
 */
public class MyListAdapter extends BaseAdapter {

    private static final String TAG = MyListAdapter.class.getSimpleName();
    ArrayList<String> listArray;

    public MyListAdapter(ArrayList<String> listArray) {
        this.listArray = listArray;
    }

    @Override
    public int getCount() {
        return listArray.size();    // total number of elements in the list
    }

    @Override
    public Object getItem(int i) {
        return listArray.get(i);    // single item in the list
    }

    @Override
    public long getItemId(int i) {
        return i;                   // index number
    }

    @Override
    public View getView(int index, View view, final ViewGroup parent) {

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.xml_item, parent, false);
        }

        TextView textView = (TextView) view.findViewById(R.id.itemText);
        textView.setText(listArray.get(index));
        Button button = (Button) view.findViewById(R.id.doneBtn);

        final int i= index;
        // button click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listArray.remove(i);
                notifyDataSetChanged();
            }
        });

        // textView click listener
        /*textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
            }
        });*/

        return view;
    }
}