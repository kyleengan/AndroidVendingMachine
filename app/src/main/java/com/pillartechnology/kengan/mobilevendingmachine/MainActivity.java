package com.pillartechnology.kengan.mobilevendingmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final double COLA_PRICE = 1.0;
    private static final double CHIPS_PRICE = 0.5;
    private static final double CANDY_PRICE = 0.65;

    private TextView statusScreen;
    private TextView coinReturn;
    private Button quarterButton;
    private Button dimeButton;
    private Button nickelButton;
    private Button pennyButton;
    private Button colaButton;
    private Button chipsButton;
    private Button candyButton;

    private NumberFormat currencyFormat;

    private double amountInserted = 0.0;
    private double amountInCoinReturn = 0.0;

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
        colaButton = (Button) findViewById(R.id.colaButton);
        chipsButton = (Button) findViewById(R.id.chipsButton);
        candyButton = (Button) findViewById(R.id.candyButton);

        configureText();

        configureClickListeners();
    }

    protected void configureText() {
        colaButton.setText(colaButton.getText() + " " + currencyFormat.format(COLA_PRICE));
        chipsButton.setText(chipsButton.getText() + " " + currencyFormat.format(CHIPS_PRICE));
        candyButton.setText(candyButton.getText() + " " + currencyFormat.format(CANDY_PRICE));

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

    protected void addAmount(double amount) {
        amountInserted += amount;

        updateStatusScreen(currencyFormat.format(amountInserted));
    }

    protected void updateStatusScreen(String text) {
        statusScreen.setText(text);
    }

    protected void addCoinReturnAmount(double amount) {
        amountInCoinReturn += amount;

        updateCoinReturn(currencyFormat.format(amountInCoinReturn));
    }

    protected void updateCoinReturn(String text) {
        coinReturn.setText(text);
    }
}
