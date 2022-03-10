package com.example.cityparcel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

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