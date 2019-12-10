package com.namankhurpia.udemy_app_php_backend.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.namankhurpia.udemy_app_php_backend.R;
import com.namankhurpia.udemy_app_php_backend.java_classes.backgroundTask;

public class MainActivity extends AppCompatActivity {

    EditText nam_ed, passsword_ed, contact_ed,country_ed;
    String name,password,contact,country;
    Button insert,fetchdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nam_ed = (EditText)findViewById(R.id.name);
        passsword_ed = (EditText)findViewById(R.id.password);
        contact_ed = (EditText)findViewById(R.id.contact);
        country_ed = (EditText)findViewById(R.id.country);

        insert = (Button)findViewById(R.id.insert);
        fetchdata = (Button)findViewById(R.id.fetch_data);

        fetchdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, fetch_json.class);
                startActivity(i);
            }
        });



        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = nam_ed.getText().toString();
                password = passsword_ed.getText().toString();
                contact = contact_ed.getText().toString();
                country = country_ed.getText().toString();

                String method = "register";
                backgroundTask bg = new backgroundTask(getApplicationContext());
                bg.execute(method,name,password,contact,country);



            }
        });

    }

}
