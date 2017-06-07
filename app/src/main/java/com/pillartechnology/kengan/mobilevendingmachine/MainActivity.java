package com.pillartechnology.kengan.mobilevendingmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView statusScreen;
    private TextView coinReturn;
    private Button quarterButton;
    private Button dimeButton;
    private Button nickelButton;
    private Button pennyButton;

    private NumberFormat currencyFormat;

    private Double amountInserted = 0.0;
    private Double amountInCoinReturn = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currencyFormat = NumberFormat.getCurrencyInstance();

        statusScreen = (TextView) findViewById(R.id.statusScreen);
        coinReturn = (TextView) findViewById(R.id.coinReturnAmount);
        quarterButton = (Button) findViewById(R.id.quarterButton);
        dimeButton = (Button) findViewById(R.id.dimeButton);
        nickelButton = (Button) findViewById(R.id.nickelButton);
        pennyButton = (Button) findViewById(R.id.pennyButton);

        configureClickListeners();
    }

    protected void configureClickListeners() {
        quarterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAmount(0.25);
            }
        });

        dimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAmount(0.10);
            }
        });

        nickelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAmount(0.05);
            }
        });

        pennyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCoinReturnAmount(0.01);
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

    protected void addCoinReturnAmount(Double amount) {
        amountInCoinReturn += amount;

        updateCoinReturn(currencyFormat.format(amountInCoinReturn));
    }

    protected void updateCoinReturn(String text) {
        coinReturn.setText(text);
    }
}
