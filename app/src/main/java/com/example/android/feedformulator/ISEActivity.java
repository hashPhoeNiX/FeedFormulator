package com.example.android.feedformulator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ISEActivity extends AppCompatActivity {

    DecimalFormat REAL_FORMATTER = new DecimalFormat("0.####");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ise);
    }

    public void calculateISE(View v){


        try{
//            Instantiating the editTexts
            EditText cp = (EditText) findViewById(R.id.cp);
            EditText fat = (EditText) findViewById(R.id.fat);

            // results
            TextView ise = (TextView) findViewById(R.id.ise_res);

            // converting the values to double
            double crude_protein = Double.parseDouble(cp.getText().toString());
            double fat_content = Double.parseDouble(fat.getText().toString());

            double ise_result = (36.5 * crude_protein) + (83.2 * fat_content) + 696.6;
            ise.setText(REAL_FORMATTER.format(ise_result));
            // ans.setText(""+result);

        } catch (Exception e){
            Context context = getApplicationContext();
            CharSequence message = "Invalid Input!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, message, duration);
            toast.show();
        }
    }
}
