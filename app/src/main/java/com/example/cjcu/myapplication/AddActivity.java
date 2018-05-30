package com.example.cjcu.myapplication;

import android.content.ContentValues;
import android.content.Entity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {


    private EditText ed_date;
    private EditText ed_info;
    private EditText ed_amount;
    private MyDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        findviews();

        helper = new MyDBHelper(this,"my.db",null,1);
    }

    private void findviews() {
        ed_date = findViewById(R.id.ed_date);
        ed_info = findViewById(R.id.ed_info);
        ed_amount = findViewById(R.id.ed_amount);
    }


    public void ADD(View view) {

            String cddate = ed_date.getText().toString();
            String info = ed_info.getText().toString();
            int amount =  Integer.parseInt(ed_amount.getText().toString()) ;

            ContentValues a = new ContentValues();
            a.put("cdate",cddate);
            a.put("info",info);
            a.put("amount",amount);
            long id = helper.getWritableDatabase().insert("exp",null,a);
        Log.d("ADD data",id+ " ");


    }
}
