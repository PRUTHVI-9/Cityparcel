package com.example.cityparcel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.cityparcel.custom.NonSwipeableViewPager;
import com.example.cityparcel.R;
import com.example.cityparcel.adapter.ViewPagerAdapter;

public class ShoppingActivity extends AppCompatActivity {
    public NonSwipeableViewPager slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiw);
        slider = findViewById(R.id.slider);
        slider.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }
}