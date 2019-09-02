package com.example.client_application;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class SPInfoActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seviceprovider_info);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle("Toolbar Title");

            CollapsingToolbarLayout collapsingToolbar =
                    (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
            collapsingToolbar.setTitle("Detailed Description");
    }
}
