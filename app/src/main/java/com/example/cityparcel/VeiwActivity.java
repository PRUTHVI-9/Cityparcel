package com.example.cityparcel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

public class VeiwActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiw);
        viewPager = findViewById(R.id.slider);
        PagerAdapter pagerAdapter = new com.example.cityparcel.PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

    }
}