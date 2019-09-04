package com.example.client_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class SPLocationActivity extends AppCompatActivity {

    private BottomSheetBehavior mBottomSheetBehaviour;
    LinearLayout tapactionlayout;
    View bottomSheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__sp__location);

        View bottomSheet = findViewById(R.id.bottom_sheet);
        mBottomSheetBehaviour = BottomSheetBehavior.from(bottomSheet);
        tapactionlayout =(LinearLayout) findViewById(R.id.tap_action_sp_layout);
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
}
