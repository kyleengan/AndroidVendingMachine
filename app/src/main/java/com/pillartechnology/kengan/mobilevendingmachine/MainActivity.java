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
    private Button coinReturnButton;

    private NumberFormat currencyFormat;

    private double amountInserted = 0.0;
    private double amountInCoinReturn = 0.0;

    private int colaAmount = 1;
    private int chipsAmount = 1;
    private int candyAmount = 1;

    private int quarterAmount = 0;
    private int dimeAmount = 2;
    private int nickelAmount = 1;

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
        coinReturnButton = (Button) findViewById(R.id.coinReturnButton);

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
                quarterAmount++;
                addAmount(0.25);
            }
        });

        dimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dimeAmount++;
                addAmount(0.10);
            }
        });

        nickelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nickelAmount++;
                addAmount(0.05);
            }
        });

        pennyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCoinReturnAmount(0.01);
            }
        });

        statusScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkStatusScreen();
            }
        });

        colaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (colaAmount == 0) {
                    updateStatusScreen(getString(R.string.sold_out));
                } else if (COLA_PRICE > amountInserted) {
                    updateStatusScreen(getString(R.string.price) + " " + currencyFormat.format(COLA_PRICE));
                } else {
                    updateStatusScreen(getString(R.string.purchased));
                    amountInserted -= COLA_PRICE;
                    returnChange(false);
                }
            }
        });

        chipsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chipsAmount == 0) {
                    updateStatusScreen(getString(R.string.sold_out));
                } else if (CHIPS_PRICE > amountInserted) {
                    updateStatusScreen(getString(R.string.price) + " " + currencyFormat.format(CHIPS_PRICE));
                } else {
                    updateStatusScreen(getString(R.string.purchased));
                    amountInserted -= CHIPS_PRICE;
                    returnChange(false);
                }
            }
        });

        candyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (candyAmount == 0) {
                    updateStatusScreen(getString(R.string.sold_out));
                } else if (CANDY_PRICE > amountInserted) {
                    updateStatusScreen(getString(R.string.price) + " " + currencyFormat.format(CANDY_PRICE));
                } else {
                    updateStatusScreen(getString(R.string.purchased));
                    amountInserted -= CANDY_PRICE;
                    returnChange(false);
                }
            }
        });

        coinReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnChange(true);
            }
        });
    }

    protected void returnChange(boolean updateDisplay) {
        // yay floating point arithmetic.
        while (amountInserted  - 0.000001 > 0.0) {
            if (amountInserted + 0.000001 >= 0.25 && quarterAmount > 0) {
                quarterAmount--;
                addCoinReturnAmount(0.25);
                amountInserted -= 0.25;
            } else if (amountInserted + 0.000001 >= 0.10 && dimeAmount > 0) {
                dimeAmount--;
                addCoinReturnAmount(0.10);
                amountInserted -= 0.10;
            } else if (amountInserted + 0.000001 >= 0.05 && nickelAmount > 0) {
                nickelAmount--;
                addCoinReturnAmount(0.05);
                amountInserted -= 0.05;
            }
        }

        amountInserted = 0.0;

        if (updateDisplay) {
            checkStatusScreen();
        }
    }

    protected void addAmount(double amount) {
        amountInserted += amount;

        checkStatusScreen();
    }

    protected void updateStatusScreen(String text) {
        statusScreen.setText(text);
    }

    protected void checkStatusScreen() {
        if (amountInserted < 0.000001) {    // basically if == 0, but, y'know... doubles.
            if (dimeAmount < 2 || nickelAmount == 0) {
                statusScreen.setText(getString(R.string.exact_change));
            } else {
                statusScreen.setText(getString(R.string.insert_coin));
            }
        } else {
            statusScreen.setText(currencyFormat.format(amountInserted));
        }
    }

    protected void addCoinReturnAmount(double amount) {
        amountInCoinReturn += amount;

        updateCoinReturn(currencyFormat.format(amountInCoinReturn));
    }

    protected void updateCoinReturn(String text) {
        if ("$0.00".equals(text)) {
            coinReturn.setText(getString(R.string.coin_return_empty));
        } else {
            coinReturn.setText(text);
        }
    }

    protected void stockProducts(int cola, int chips, int candy) {
        colaAmount = cola;
        chipsAmount = chips;
        candyAmount = candy;
    }

    protected void stockCoins(int quarters, int dimes, int nickels) {
        quarterAmount = quarters;
        dimeAmount = dimes;
        nickelAmount = nickels;
    }
}
