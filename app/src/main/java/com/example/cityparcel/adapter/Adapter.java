package com.example.cityparcel.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cityparcel.fragments.page1;
import com.example.cityparcel.fragments.page2;
import com.example.cityparcel.fragments.page3;
import com.example.cityparcel.fragments.page4;

public class Adapter extends FragmentStateAdapter {


    public Adapter(@NonNull Fragment fragment) {
        super(fragment);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new page1();
            case 1:
                return new page2();
            case 2:
                return new page3();
            case 3:
                return new page4();
            default:
                new page1();
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 4;
    }

}
