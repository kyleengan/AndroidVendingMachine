# AndroidVendingMachine
Vending Machine kata done in Android, with UI


Please use Android Studio to run the application and the associated tests.

Due to my losing a fight with Robolectric, you may need to run the tests from the command line - I'm unsure if my Run Configurations saved over source control.

The tests can be run from the command line with "gradlew :app:testDebugUnitTest".  

If you'd prefer to run them within the UI, I believe you'll need to hit Edit Configurations and add the Module Directory as the working directory for the test run configuration (per https://stackoverflow.com/questions/43971063/android-unit-testing-robolectric3-3-2-no-such-manifest-file-build-intermedia).



Thanks for your time and consideration!

Kyle Engan



NOTE: For meeting the "next time the status display is checked..." requirements (e.g. after displaying the price of a product), the status display is tappable.  In a perfect world, I'd have used a timer, but I lost the fight on how to TDD those.  Apologies!
