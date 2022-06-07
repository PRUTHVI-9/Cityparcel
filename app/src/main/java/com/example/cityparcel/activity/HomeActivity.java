package com.example.cityparcel.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.cityparcel.CheckoutActivity;
import com.example.cityparcel.fragments.FarmFragment;
import com.example.cityparcel.fragments.Gift_ItemsFragment;
import com.example.cityparcel.custom.NonSwipeableViewPager;
import com.example.cityparcel.fragments.NonVegFragment;
import com.example.cityparcel.R;
import com.example.cityparcel.fragments.RestaurantDetailsFragment;
import com.example.cityparcel.fragments.RestaurantFragment;
import com.example.cityparcel.adapter.SwipeBasdeAdapter;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {
    Spinner select_location;
    String[] arr = {"Select Location", "Thane", "Mulund", "Nahur", "Bhandup", "Kanjur", "Vikhroli", "Ghatkopar"};
    NonSwipeableViewPager pager;
    Menu menu;
    public androidx.appcompat.widget.Toolbar toolbar;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        select_location = findViewById(R.id.select_location);
        pager = findViewById(R.id.vp_slider);
        toolbar = findViewById(R.id.tb_tool);
        tabLayout = findViewById(R.id.tab);

        setSupportActionBar(toolbar);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(HomeActivity.this, R.layout.spinner_item,arr);
        select_location.setAdapter(adapter);

        select_location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("TAG", "onItemSelected: " + select_location.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        SwipeBasdeAdapter swipeBasdeAdapter = new SwipeBasdeAdapter(getSupportFragmentManager());
        pager.setAdapter(swipeBasdeAdapter);
        pager.setOffscreenPageLimit(4);

        tabLayout.setupWithViewPager(pager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            switch (i) {
                case 0:
                    tabLayout.getTabAt(i).setIcon(R.drawable.ic_baseline_home_24_orange);
                    break;
                case 1:

                    tabLayout.getTabAt(i).setIcon(R.drawable.ic_cart_24);
                    break;
                case 2:
                    tabLayout.getTabAt(i).setIcon(R.drawable.ic_dining);
                    break;
                case 3:
                    tabLayout.getTabAt(i).setIcon(R.drawable.ic_person_24);
                    break;


            }
        }

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < tabLayout.getTabCount(); i++) {
                    switch (i) {
                        case 0:
                            if (position == 0) {
                                tabLayout.getTabAt(i).setIcon(R.drawable.ic_baseline_home_24_orange);
                            } else
                                tabLayout.getTabAt(i).setIcon(R.drawable.ic_baseline_home_24);
                            break;
                        case 1:
                            if (position == 1) {
                                tabLayout.getTabAt(i).setIcon(R.drawable.ic_cart_24_orange);
                            } else
                                tabLayout.getTabAt(i).setIcon(R.drawable.ic_cart_24);
                            break;
                        case 2:
                            if (position == 2) {
                                tabLayout.getTabAt(i).setIcon(R.drawable.ic_dining_orange);
                            } else
                                tabLayout.getTabAt(i).setIcon(R.drawable.ic_dining);
                            break;
                        case 3:
                            if (position == 3) {
                                tabLayout.getTabAt(i).setIcon(R.drawable.ic_person_24_orange);
                            } else
                                tabLayout.getTabAt(i).setIcon(R.drawable.ic_person_24);
                            break;


                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.base_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.homeframe1);
        if (fragment != null) {
            if (fragment instanceof NonVegFragment) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                return;
            }
            if (fragment instanceof RestaurantFragment) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                return;
            }
            if (fragment instanceof FarmFragment) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                return;
            }
            if (fragment instanceof Gift_ItemsFragment) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                return;
            }
            if (fragment instanceof RestaurantDetailsFragment) {
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                return;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();

            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setMessage("Are you want to close this View");
        builder.create();
        builder.show();
    }
}
