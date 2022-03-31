package com.example.cityparcel.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityparcel.adapter.CartListAdapter;
import com.example.cityparcel.R;

public class MyCartFragment extends Fragment {
    RecyclerView cartList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_cart,container,false);
        cartList = view.findViewById(R.id.cartList);
        cartList.setLayoutManager(new LinearLayoutManager(getContext()));
        cartList.setAdapter(new CartListAdapter(getContext()));
        return view;
    }
}
