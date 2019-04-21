package com.example.judithehiguese.contactmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class FinalActivity extends Activity {

    TextView conName;
    TextView conMobile;
    TextView conHome;
    TextView conEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        conName = (TextView)findViewById(R.id.viewName);
        conMobile = (TextView)findViewById(R.id.viewMobile);
        conHome = (TextView)findViewById(R.id.viewHome);
        conEmail = (TextView)findViewById(R.id.viewEmail);

        Intent gin = getIntent();

        Bundle bin = gin.getExtras();

        if (bin != null){

            String cName = (String)bin.get("cName");
            String cMobile = (String)bin.get("cMobile");
            String cHome = (String)bin.get("cHome");
            String cEmail = (String)bin.get("cEmail");

            conName.setText(cName);
            conMobile.setText(cMobile);
            conHome.setText(cHome);
            conEmail.setText(cEmail);
        }


    }
}
