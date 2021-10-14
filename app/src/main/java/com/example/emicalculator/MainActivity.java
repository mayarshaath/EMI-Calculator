package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // define the global variable
    EditText mortgage;
    EditText rate;
    EditText years;
    Button calculate;
    TextView answer;
    int ans=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tie variables to their xml id
        mortgage = (EditText) findViewById(R.id.mortgageAmount);
        rate = (EditText) findViewById(R.id.interestRate);
        years = (EditText) findViewById(R.id.timeInYears);
        calculate = (Button) findViewById(R.id.calculate);
        answer = (TextView) findViewById(R.id.answer);

        //add clicklistener to the calculate button
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data in edittext and convert to string
                //convert to Double using parseDouble
                double m = Double.parseDouble(mortgage.getText().toString());
                double r = Double.parseDouble(rate.getText().toString());
                //interest rate is per year so we divide to get monthly rate
                double rate = (r/100)/12;
                double y = Double.parseDouble(years.getText().toString());
                //time is taken in years so we divide to get monthly time
                double t = y * 12;
                //the formula for monthly payments, store answer in p
                double p = (m * rate) / (1 - Math.pow(1 + rate, -t));
                //set it to answer textview
                answer.setText(Double.toString(p));
            }
        });
    }
}