package com.assignment3.s64482790;

/* Student Number: 64482790
   Name: Sashin Smith
   Purpose: The  purpose of this app is to determine  the total interest paid on a mortgage loan.
            It is developed in accordance with the specification for the module ICT2612
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    //Declaring variables to use for calculations and saving
    int initialPayment, monthlyPayment, months;
    float interest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting data on the current fields
        final EditText iPayment = (EditText)findViewById(R.id.edtNumIntial);
        final EditText mPayment = (EditText)findViewById(R.id.edtNumPayment);
        final Spinner numYears = (Spinner)findViewById(R.id.spnYears);

        Button calc = (Button)findViewById(R.id.btnCalc);

        //creating shared preferences to be saved when button and data has been entered
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting data
                initialPayment = Integer.parseInt(iPayment.getText().toString());
                monthlyPayment = Integer.parseInt(mPayment.getText().toString());
                String years = numYears.getSelectedItem().toString();

                //converting years into months and calculating interest
                months = Integer.parseInt(years);
                months *= 12;
                interest = monthlyPayment * months - initialPayment;

                //writing dta to shared preferences to be used in next activity
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", initialPayment);
                editor.putInt("key2", monthlyPayment);
                editor.putInt("key3", months);
                editor.putFloat("key4", interest);
                editor.commit();

                //takes user to next activity
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
    }
}