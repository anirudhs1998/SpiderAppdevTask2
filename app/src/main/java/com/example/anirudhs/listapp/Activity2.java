package com.example.anirudhs.listapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

       TextView displayText = (TextView)findViewById(R.id.displayText);
        displayText.setText(getIntent().getExtras().getString("itemname"));
    }
}
