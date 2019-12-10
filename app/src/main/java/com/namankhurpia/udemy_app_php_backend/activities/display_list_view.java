package com.namankhurpia.udemy_app_php_backend.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.namankhurpia.udemy_app_php_backend.R;
import com.namankhurpia.udemy_app_php_backend.java_classes.contact_adapter;
import com.namankhurpia.udemy_app_php_backend.schema.contacts;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class display_list_view extends AppCompatActivity {

    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;

    contact_adapter conadapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view);

        conadapter = new contact_adapter(this,R.layout.list_row_item);
        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(conadapter);
        JSON_STRING = getIntent().getExtras().getString("jsondata");
        Log.d("receive",JSON_STRING);
        String name,country,contact,password;

        try {
            jsonObject =new JSONObject(JSON_STRING);
            int count = 0;
            jsonArray = jsonObject.getJSONArray("server response");
            while(count<jsonArray.length())
            {
                JSONObject jo = jsonArray.getJSONObject(count);
                name= jo.getString("name");
                password= jo.getString("password");
                contact= jo.getString("contact");
                country= jo.getString("country");
                Log.d("$$$$namae",name);
                contacts c = new contacts(name,password,contact,country);
                conadapter.add(c);
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
