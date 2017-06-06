package com.pillartechnology.kengan.mobilevendingmachine;

import com.pillartechnology.kengan.mobilevendingmachine.BuildConfig;

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

    TextView statusScreen;
    Button quarterButton;
    Button dimeButton;
    Button nickelButton;
    Button pennyButton;

    @Before
    public void setUp() {
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        statusScreen = (TextView) activity.findViewById(R.id.statusScreen);
        quarterButton = (Button) activity.findViewById(R.id.quarterButton);
        dimeButton = (Button) activity.findViewById(R.id.dimeButton);
        nickelButton = (Button) activity.findViewById(R.id.nickelButton);
        pennyButton = (Button) activity.findViewById(R.id.pennyButton);
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
}
