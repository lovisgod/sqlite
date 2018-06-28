package com.example.ayo.sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewListContent extends AppCompatActivity {

    DbHelper mydb;
    ListView listView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);

        listView =(ListView)findViewById(R.id.list_content);
        mydb=new DbHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = mydb.getListContents();

        if(data.getCount()==0){
            Toast.makeText(ViewListContent.this,"The Database is empty",Toast.LENGTH_LONG).show();
        }else{
            while (data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
