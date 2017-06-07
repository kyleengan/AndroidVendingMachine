package com.pillartechnology.kengan.mobilevendingmachine;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    private TextView statusScreen;
    private Button quarterButton;
    private Button dimeButton;
    private Button nickelButton;
    private Button pennyButton;
    private Button colaButton;
    private TextView coinReturnLabel;
    private TextView coinReturnAmount;


    @Before
    public void setUp() {
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        statusScreen = (TextView) activity.findViewById(R.id.statusScreen);
        coinReturnAmount = (TextView) activity.findViewById(R.id.coinReturnAmount);
        coinReturnLabel = (TextView) activity.findViewById(R.id.coinReturnLabel);
        quarterButton = (Button) activity.findViewById(R.id.quarterButton);
        dimeButton = (Button) activity.findViewById(R.id.dimeButton);
        nickelButton = (Button) activity.findViewById(R.id.nickelButton);
        pennyButton = (Button) activity.findViewById(R.id.pennyButton);
        colaButton = (Button) activity.findViewById(R.id.colaButton);
    }

    @Test
    public void statusScreenReadsINSERT_COIN_whenInitialized() {
        assertEquals("INSERT COIN", statusScreen.getText());
    }

    @Test
    public void quarterButtonReads25C_whenInitialized() {
        assertEquals("25C", quarterButton.getText());
    }

    @Test
    public void dimeButtonReads10C_whenInitialized() {
        assertEquals("10C", dimeButton.getText());
    }

    @Test
    public void nickelButtonReads5C_whenInitialized() {
        assertEquals("5C", nickelButton.getText());
    }

    @Test
    public void pennyButtonReads1C_whenInitialized() {
        assertEquals("1C", pennyButton.getText());
    }

    @Test
    public void colaButtonReadsCola100_whenInitialized() {
        assertEquals("COLA: $1.00", colaButton.getText());
    }

    @Test
    public void coinReturnLabelReadsCoinReturn_whenInitialized() {
        assertEquals("Coin Return:", coinReturnLabel.getText());
    }

    @Test
    public void coinReturnAmountReadsEmpty_whenInitialized() {
        assertEquals("Empty", coinReturnAmount.getText());
    }

    @Test
    public void pressingQuarterButton_updatesAmountInsertedBy25Cents() {
        quarterButton.performClick();

        assertEquals("$0.25", statusScreen.getText());
    }

    @Test
    public void pressingQuarterButtonTwice_updatesAmountInsertedBy50Cents() {
        quarterButton.performClick();
        quarterButton.performClick();

        assertEquals("$0.50", statusScreen.getText());
    }

    @Test
    public void pressingDimeButton_updatesAmountInsertedBy10Cents() {
        dimeButton.performClick();

        assertEquals("$0.10", statusScreen.getText());
    }

    @Test
    public void pressingNickelButton_updatesAmountInsertedBy5Cents() {
        nickelButton.performClick();

        assertEquals("$0.05", statusScreen.getText());
    }

    @Test
    public void pressingQuarterNickelAndDimeButtons_updatesAmountInsertedBy40Cents() {
        quarterButton.performClick();
        dimeButton.performClick();
        nickelButton.performClick();

        assertEquals("$0.40", statusScreen.getText());
    }

    @Test
    public void pressingPennyButton_updatesCoinReturnAmount() {
        pennyButton.performClick();

        assertEquals("$0.01", coinReturnAmount.getText());
    }


}
