package com.assignment3.s64482790;

/* Student Number: 64482790
   Name: Sashin Smith
   Purpose: The  purpose of this app is to determine  the total interest paid on a mortgage loan.
            It is developed in accordance with the specification for the module ICT2612
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {
    //writes images into array
    Integer[] imgNums = {R.drawable.img10, R.drawable.img20, R.drawable.img30};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final ImageView imgDisplay = (ImageView) findViewById(R.id.imgDisplayNum);

        //writes data from shared preferences to variables
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int initialPayment = sharedPref.getInt("key1",0);
        int monthlyPayment = sharedPref.getInt("key2", 0);
        int months = sharedPref.getInt("key3",0);
        float interest = sharedPref.getFloat("key4",0);

        //determines which picture to use based on years
        int imgToUse = months/12;
        switch (imgToUse){
            case 10:
                imgDisplay.setImageResource(imgNums[0]);
                break;
            case 20:
                imgDisplay.setImageResource(imgNums[1]);
                break;
            case 30:
                imgDisplay.setImageResource(imgNums[2]);
                break;
        }

        //creates formats for display
        DecimalFormat currency = new DecimalFormat("R###,###,###.##");
        DecimalFormat percentage = new DecimalFormat("##%");

        //writes data to TextView for the  user to  see
        //\n places strings on new lines
        final TextView txtOutput = (TextView)findViewById(R.id.txtOutPut);
        txtOutput.append("Total Interest: " + currency.format(interest) + "\n");
        //calculates interest percentage
        interest = interest/initialPayment;
        txtOutput.append("Interest Percentage: " + percentage.format(interest) + "\n");
        txtOutput.append("Initial Payment: " + currency.format(initialPayment) + "\n");
        txtOutput.append("Monthly Payments: " + currency.format(monthlyPayment));
    }
}