package com.example.android.feedformulator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class NFEActivity extends AppCompatActivity {

    DecimalFormat REAL_FORMATTER = new DecimalFormat("0.####");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfe);
    }

    public void calculateNfe(View v){


        try{
//            Instantiating the editTexts

            EditText cp = (EditText) findViewById(R.id.cp);
            EditText fat = (EditText) findViewById(R.id.fat);
            EditText cf = (EditText) findViewById(R.id.fibre);
            EditText ash = (EditText) findViewById(R.id.ash);
            EditText moist = (EditText) findViewById(R.id.moisture);
            // results
            TextView nfe = (TextView) findViewById(R.id.nfe_result);
            TextView wse = (TextView) findViewById(R.id.wse_res);

            // converting the values to double
            double crude_protein = Double.parseDouble(cp.getText().toString());
            double fat_content = Double.parseDouble(fat.getText().toString());
            double crude_fibre = Double.parseDouble(cf.getText().toString());
            double ash_content = Double.parseDouble(ash.getText().toString());
            double moisture = Double.parseDouble(moist.getText().toString());

            double nfe_result = 100 - (crude_protein + fat_content + crude_fibre + ash_content + moisture);
            nfe.setText(REAL_FORMATTER.format(nfe_result));

            double wse_result = (37 * crude_protein) + (81.8 * fat_content) + (35 * nfe_result);
            wse.setText(REAL_FORMATTER.format(wse_result));
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
