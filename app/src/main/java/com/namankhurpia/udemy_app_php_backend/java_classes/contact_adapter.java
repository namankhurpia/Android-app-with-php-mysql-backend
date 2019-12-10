package com.namankhurpia.udemy_app_php_backend.java_classes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.namankhurpia.udemy_app_php_backend.R;
import com.namankhurpia.udemy_app_php_backend.schema.contacts;

import java.util.ArrayList;
import java.util.List;

public class contact_adapter extends ArrayAdapter {

    List list = new ArrayList();

    public contact_adapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(contacts object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row ;
        row = convertView;
        contactholder ch;
        if(row==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.list_row_item,parent,false);
            ch = new contactholder();

            ch.tx_name = (TextView)row.findViewById(R.id.txname);
            ch.tx_password = (TextView)row.findViewById(R.id.txpassword);
            ch.tx_contact = (TextView)row.findViewById(R.id.txcontact);
            ch.tx_counntry = (TextView)row.findViewById(R.id.txcountry);
            row.setTag(ch);



        }
        else
        {
            ch = (contactholder)row.getTag();
        }
        contacts cc = (contacts)this.getItem(position);
        Log.d("$$$$$name",cc.getName());
        Log.d("$$$$$name",cc.getPassword());
        Log.d("$$$$$name",cc.getContact());
        Log.d("$$$$$name",cc.getCountry());
        ch.tx_name.setText(cc.getName());
        ch.tx_password.setText(cc.getPassword());
        ch.tx_contact.setText(cc.getContact());
        ch.tx_counntry.setText(cc.getCountry());
        return row;

    }

    static class contactholder
    {
        TextView tx_name,tx_password,tx_contact,tx_counntry;

    }

}
