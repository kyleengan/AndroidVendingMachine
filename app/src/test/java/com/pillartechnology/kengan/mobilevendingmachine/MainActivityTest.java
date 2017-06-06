package com.pillartechnology.kengan.mobilevendingmachine;

import com.pillartechnology.kengan.mobilevendingmachine.BuildConfig;

import android.app.Activity;
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

    @Before
    public void setUp() {
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        statusScreen = (TextView) activity.findViewById(R.id.statusScreen);
    }

    @Test
    public void statusScreenReadsINSERT_COIN_whenInitialized() {
        assertEquals("INSERT COIN", statusScreen.getText());
    }
}
