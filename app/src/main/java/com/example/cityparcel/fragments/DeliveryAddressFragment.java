package com.example.cityparcel.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.cityparcel.PaymentActivity;
import com.example.cityparcel.R;


public class DeliveryAddressFragment extends Fragment {
    Button next;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view =inflater.inflate(R.layout.fragment_delivery_address, container, false);
        next = view.findViewById(R.id.next3);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PaymentActivity.class));

            }
        });
        return view;
    }
}