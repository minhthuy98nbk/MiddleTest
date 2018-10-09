package com.example.cndd.middletest;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity1 extends AppCompatActivity {

    private EditText etA, etB;
    private Button btnSend;
    private ListView lv;
    ArrayList<String> arrKetQua = new ArrayList<String>();
    ArrayAdapter<String> adapter = null;
    public static final String NumberA = "numbera", NumberB = "numberb";
    public static final int request_code = 1011;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        etA = (EditText) findViewById(R.id.etA);
        etB = (EditText) findViewById(R.id.etB);
        btnSend = (Button) findViewById(R.id.btnSend);
        lv = (ListView) findViewById(R.id.lv);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrKetQua);
        lv.setAdapter(adapter);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( check(etA.getText().toString())==false || check(etB.getText().toString())==false ){
                    Toast.makeText(Activity1.this,"Dữ liệu sai",Toast.LENGTH_LONG).show();
                    return;
                } else {
                    int number_a = Integer.parseInt(etA.getText().toString());
                    int number_b = Integer.parseInt(etB.getText().toString());
                    Intent intent = new Intent(Activity1.this, Activity2.class);
                    intent.putExtra(NumberA, number_a);
                    intent.putExtra(NumberB, number_b);
                    startActivityForResult(intent, request_code);
                }
            }
        });
    }

    public boolean check (String s){
        if (s.equals("")==true) return false;
        for(int i=0; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) == false) return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == request_code) {
            switch (resultCode) {
                case Activity2.RESULT_PIN:
                    String result = data.getStringExtra(Activity2.result);
                    arrKetQua.add(result);
                    adapter.notifyDataSetChanged();
                    //Toast.makeText(this, result, Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
    }
}
