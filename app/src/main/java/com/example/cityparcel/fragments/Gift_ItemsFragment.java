package com.example.cityparcel.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cityparcel.javaclass.Farm;
import com.example.cityparcel.adapter.FarmAdapter;
import com.example.cityparcel.R;

import java.util.ArrayList;
import java.util.List;


public class Gift_ItemsFragment extends Fragment {
    RecyclerView recyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gift__items, container, false);
        recyclerView = view.findViewById(R.id.gift_items);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));


        List<Farm> list = new ArrayList<>();
        list.add(new Farm("Wooden Toy","&#8377 50",R.drawable.wooden));
        list.add(new Farm("Handmade Painting","&#8377 50",R.drawable.handmade));
        list.add(new Farm("The Craft Store","&#8377 50",R.drawable.craft));
        list.add(new Farm("Priented Mug Shop","&#8377 50",R.drawable.mug));
        list.add(new Farm("Soft Teddy Shop","&#8377 50",R.drawable.teddy));
        list.add(new Farm("Bottle Planter","&#8377 50",R.drawable.bottle));
        list.add(new Farm("Statue Shop","&#8377 50",R.drawable.gift1));
        list.add(new Farm("Gift Shop","&#8377 50",R.drawable.gift2));
        recyclerView.setAdapter(new FarmAdapter(getContext(),list));

        return view;
    }
}