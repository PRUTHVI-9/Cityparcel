package com.example.cityparcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

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
