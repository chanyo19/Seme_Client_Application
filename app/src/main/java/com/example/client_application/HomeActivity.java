package com.example.client_application;


import android.os.Bundle;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BottomSheetBehavior mBottomSheetBehaviour;
    LinearLayout tapactionlayout;
    View bottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Bottom_ Sheet Activities
        View bottomSheet = findViewById(R.id.bottom_sheet);
        mBottomSheetBehaviour = BottomSheetBehavior.from(bottomSheet);
        navigationView.setNavigationItemSelectedListener(this);
        tapactionlayout =(LinearLayout) findViewById(R.id.tap_action_layout);
        mBottomSheetBehaviour.setPeekHeight(120);
        mBottomSheetBehaviour.setState(BottomSheetBehavior.STATE_COLLAPSED);
        mBottomSheetBehaviour.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState == BottomSheetBehavior.STATE_COLLAPSED)
                {
                    tapactionlayout.setVisibility(View.VISIBLE);
                }
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    tapactionlayout.setVisibility(View.GONE);
                }

                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    tapactionlayout.setVisibility(View.GONE);
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
        tapactionlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mBottomSheetBehaviour.getState()==BottomSheetBehavior.STATE_COLLAPSED)
                {
                    mBottomSheetBehaviour.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }
        });



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWit hEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
