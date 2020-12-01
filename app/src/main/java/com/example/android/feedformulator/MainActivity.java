package com.example.android.feedformulator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nfe(View view){
        Intent intent = new Intent(this, NFEActivity.class);
        startActivity(intent);
//        TextView cp = (TextView) findViewById(R.id.cp);

    }

    public void whole_sample(View view){

    }

    public void individual_sample(View view){
        Intent intent = new Intent(this, ISEActivity.class);
        startActivity(intent);
    }

}
