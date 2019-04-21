package com.example.judithehiguese.contactmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity {
    DatabaseHelper myDB; //instance of database
    EditText editName, editMobile, editHome, editEmail, editTextId;
    Button btnViewAll, btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        myDB = new DatabaseHelper(this); //call constructor of DatabaseHelper class

        editName = (EditText)findViewById(R.id.editText_name);
        editMobile = (EditText)findViewById(R.id.editText_mobile);
        editHome = (EditText)findViewById(R.id.editText_home);
        editEmail = (EditText)findViewById(R.id.editText_email);
        btnViewAll = (Button)findViewById(R.id.button_view);
        btnAddData = (Button)findViewById(R.id.button_add);
        AddData();

        btnViewAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    //call insert data method / add contact
    public void AddData(){
        btnAddData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        boolean isInserted = myDB.insertData(editName.getText().toString(),
                                editMobile.getText().toString(),
                                editHome.getText().toString(),
                                editEmail.getText().toString());
                        if(isInserted=true)
                            Toast.makeText(SecondActivity.this, "Data is Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SecondActivity.this, "Data is not Inserted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }


    public void viewAllBtn(View view){

        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void cancelBtn(View view){

        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
    }


}

