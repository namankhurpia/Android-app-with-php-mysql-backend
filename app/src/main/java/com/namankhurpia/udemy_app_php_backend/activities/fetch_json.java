package com.namankhurpia.udemy_app_php_backend.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.namankhurpia.udemy_app_php_backend.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetch_json extends AppCompatActivity  {

    Button getjson,parsejson;
    TextView text;
    String json_string;
    String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_json);

        getjson = (Button)findViewById(R.id.getjson);
        parsejson = (Button)findViewById(R.id.parse_json);
        text = (TextView)findViewById(R.id.textview);

        getjson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new bgtask().execute();

            }
        });

        parsejson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(fetch_json.this, display_list_view.class);
                Log.d("sending",JSON_STRING);
                i.putExtra("jsondata",JSON_STRING);
                startActivity(i);

            }
        });


    }

    class bgtask extends AsyncTask<Void,Void,String>
    {
        public bgtask() {
            super();
        }

        String json_url="https://namankhurpia.000webhostapp.com/getjson.php";


        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView = findViewById(R.id.textview);
            textView.setText(result);
            JSON_STRING = result;
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while((json_string=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(json_string+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;

        }
    }


}


