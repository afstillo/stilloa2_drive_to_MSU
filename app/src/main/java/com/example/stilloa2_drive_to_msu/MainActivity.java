package com.example.stilloa2_drive_to_msu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/*
NOTE: due to the simple nature of this assignment, I decided to take an extra step and add
the avoid feature as well. Knowledge of this feature was obtained from:
https://developers.google.com/maps/documentation/urls/android-intents
 */

public class MainActivity extends AppCompatActivity {
    Button drive;
    CheckBox t, h, f;
    String uri;
    /*
    drive = variable for the button in the XML.
    t, h, f = correspond to each checkbox in the XML. Used for the avoid feature.
        t = tolls, h = highways, f = ferries.
    uri = string for dynamic avoidance tag creation.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drive = findViewById(R.id.drive);
        t = findViewById(R.id.t);
        h = findViewById(R.id.h);
        f = findViewById(R.id.f);
    }

    public void onClick (View V) {
        //uri declaration.
        uri = "google.navigation:q=Montclair+State+University+Montclair+New+Jersey";

        //Checking the checkboxes, and adding an avoidance tag if necessary.
        if (t.isChecked() || h.isChecked() || f.isChecked()) {
            uri += "&avoid=";

            //checking t.
            if (t.isChecked())
            {
                uri += "t";
            }
            //checking h.
            if (h.isChecked())
            {
                uri += "h";
            }
            //checking f.
            if (f.isChecked())
            {
                uri += "f";
            }
        }
        System.out.print(uri);

        //Intent creation in query format.
        Uri gmmIntentUri = Uri.parse(uri);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}