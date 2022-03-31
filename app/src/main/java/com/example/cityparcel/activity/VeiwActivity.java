package com.example.cityparcel.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.cityparcel.R;

public class VeiwActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiw);
        viewPager = findViewById(R.id.slider);
        PagerAdapter pagerAdapter = new com.example.cityparcel.adapter.PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

    }
}