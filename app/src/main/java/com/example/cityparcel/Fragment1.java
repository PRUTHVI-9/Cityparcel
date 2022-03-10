package com.example.cityparcel;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Fragment1 extends Fragment {
    Button next;
    TextView skip;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);
        next = view.findViewById(R.id.next);
        skip = view.findViewById(R.id.skip_fragment);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SignInActivity.class);
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