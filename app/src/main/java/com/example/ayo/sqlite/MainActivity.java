package com.example.ayo.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DbHelper myDb;
    Button buttonAdd, buttonView;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.enter);
        buttonAdd = (Button)findViewById(R.id.add_button);
        buttonView= (Button)findViewById(R.id.view_item);
        myDb=new DbHelper(this);

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewListContent.class));
                finish();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if(editText.length()!=0){
                    AddData(newEntry);
                    editText.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"you must got something inside the text field",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void AddData(String newEntry){
        boolean insertData = myDb.addData(newEntry);

        if(insertData==true){
            Toast.makeText(MainActivity.this,"successfully entered",Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(MainActivity.this," something is wrong, not successfully entered",Toast.LENGTH_LONG).show();
        }
    }
}
