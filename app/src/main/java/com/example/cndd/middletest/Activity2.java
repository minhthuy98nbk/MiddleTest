package com.example.cndd.middletest;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Activity2 extends AppCompatActivity {

    private TextView tvA, tvB;
    private Button btnCong, btnDu;
    private int a, b;
    public static final String result = "result";
    public static final int RESULT_PIN = 2018;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvA = (TextView) findViewById(R.id.tvA);
        tvB = (TextView) findViewById(R.id.tvB);
        btnCong = (Button) findViewById(R.id.btnCong);
        btnDu = (Button) findViewById(R.id.btnDu);

        Intent intent = getIntent();
        a = intent.getIntExtra(Activity1.NumberA, 0);
        b = intent.getIntExtra(Activity1.NumberB, 0);
        tvA.setText(a + "");
        tvB.setText(b + "");


        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(result,  a + " + " + b + " = " + (a + b) + "");
                setResult(RESULT_PIN, intent);
                finish();
            }
        });

        btnDu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(result,  a + " % " + b + " = "+  (a % b) + "");
                setResult(RESULT_PIN, intent);
                finish();
            }
        });

    }

}
