package com.example.cityparcel.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.cityparcel.fragments.BaseFragment;
import com.example.cityparcel.fragments.DiningFragment;
import com.example.cityparcel.fragments.MyAccountFragment;
import com.example.cityparcel.fragments.MyCartFragment;

public class SwipeBasdeAdapter extends FragmentPagerAdapter {
    public SwipeBasdeAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new BaseFragment();
            case 1:
                return new MyCartFragment();
            case 2:
                return new DiningFragment();
            case 3:
                return new MyAccountFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;


    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Home";
                case 1:
                return "My Cart";
                case 2:
                return "Dining";
                case 3:
                return "My Account";
            default:
                return "";
        }
    }
}

