package com.example.cityparcel.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cityparcel.R;
import com.example.cityparcel.activity.ProfileActivity;
import com.example.cityparcel.activity.ShoppingActivity;
import com.example.cityparcel.activity.SignInActivity;


public class Fragment1 extends Fragment {
    Button next,test;
    TextView skip;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);
        next = view.findViewById(R.id.next);
        skip = view.findViewById(R.id.skip_fragment);
        test = view.findViewById(R.id.test);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SignInActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ShoppingActivity) getActivity()).slider.setCurrentItem(1);
            }
        });



        return view;
    }
}