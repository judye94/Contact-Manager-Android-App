package com.example.judithehiguese.contactmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends Activity {


    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final ListView listView = (ListView) findViewById(R.id.lv_mainlist);
        myDB = new DatabaseHelper(this);

        //populate an ArrayList<String> from the database and then view it
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getAllData();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list. Create one below!",Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
                registerForContextMenu(listView);
            }

            

        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, FinalActivity.class);
                intent.putExtra("cName", listView.getItemAtPosition(position).toString());
                intent.putExtra("cMobile", listView.getItemAtPosition(position).toString());
                intent.putExtra("cHome", listView.getItemAtPosition(position).toString());
                intent.putExtra("cEmail", listView.getItemAtPosition(position).toString());
                startActivity(intent);

            }
        });



    }



    public void secondActivityBtn(View view){

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }



}
