package com.example.cityparcel;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class RestaurantDetailsFragment extends Fragment {
    ViewPager2 viewPager;
    ImageView imageView;
    TabLayout tablayout;
    TextView text_card1, text_card2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_details, container, false);
        viewPager = view.findViewById(R.id.viewpager);
        imageView = view.findViewById(R.id.imagebs);
        text_card1 = view.findViewById(R.id.text_card1);
        text_card2 = view.findViewById(R.id.text_card2);
        tablayout = view.findViewById(R.id.tablayout);
        Adapter adapter = new Adapter(this);
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tablayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Menu");
                            break;
                        case 1:
                            tab.setText("Photos");
                            break;
                        case 2:
                            tab.setText("Review");
                            break;
                        case 3:
                            tab.setText("About");
                            break;
                    }
                }
        ).attach();
//        tab.setupWithViewPager(viewPager);
//        viewPager.setNestedScrollingEnabled(false);
        viewPager.isNestedScrollingEnabled();


        Bundle bundle = getArguments();
        imageView.setImageResource(bundle.getInt("image"));
        text_card1.setText(bundle.getString("title"));
        text_card2.setText(bundle.getString("discription"));


        CardView ll_bs = view.findViewById(R.id.ll_bs);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(ll_bs);
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        return view;
    }
}
