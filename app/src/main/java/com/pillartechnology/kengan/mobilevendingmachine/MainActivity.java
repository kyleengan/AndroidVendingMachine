package com.pillartechnology.kengan.mobilevendingmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView statusScreen;
    private Button quarterButton;

    private NumberFormat currencyFormat;

    private Double amountInserted = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currencyFormat = NumberFormat.getCurrencyInstance();

        statusScreen = (TextView) findViewById(R.id.statusScreen);
        quarterButton = (Button) findViewById(R.id.quarterButton);

        configureClickListeners();
    }

    protected void configureClickListeners() {
        quarterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAmount(0.25);
            }
        });
    }

    protected void addAmount(Double amount) {
        amountInserted += amount;

        updateStatusScreen(currencyFormat.format(amountInserted));
    }

    protected void updateStatusScreen(String text) {
        statusScreen.setText(text);
    }
}
