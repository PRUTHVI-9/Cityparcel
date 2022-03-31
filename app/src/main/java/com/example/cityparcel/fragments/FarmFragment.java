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


public class FarmFragment extends Fragment {
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_farm, container, false);
      recyclerView = view.findViewById(R.id.farm_products);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        List<Farm> list = new ArrayList<>();
        list.add(new Farm("Fresh Farm Grapes","&#8377 50/kg",R.drawable.grapes));
        list.add(new Farm("Fresh Strawberry","&#8377 100/kg",R.drawable.strawberry));
        list.add(new Farm("Fresh Mango","&#8377 250/kg",R.drawable.mango));
        list.add(new Farm("Fresh Farm Banana","&#8377 30/dozen",R.drawable.bananas));
        list.add(new Farm("Fresh Farm Oranges","&#8377 150/kg",R.drawable.oranges));
        list.add(new Farm("Fresh Farm Apples","&#8377 200/kg",R.drawable.apples));
        list.add(new Farm("Fresh Pineapple","&#8377 40/kg",R.drawable.pineapple));
        list.add(new Farm("Pomegranate","&#8377 80/kg",R.drawable.pomegranate));
        list.add(new Farm("Watermelon","&#8377 50/kg",R.drawable.watermelaon));
        list.add(new Farm("Fresh Papaya","&#8377 30/kg",R.drawable.papaya));
        list.add(new Farm("Fresh Cherry","&#8377 120/kg",R.drawable.cherries));
        list.add(new Farm("Fresh Kiwifruit","&#8377 150/kg",R.drawable.kiwi));
        list.add(new Farm("Custard-Apple","&#8377 90/kg",R.drawable.custard));
        list.add(new Farm("Fresh Guava","&#8377 100/kg",R.drawable.guava));
        recyclerView.setAdapter(new FarmAdapter(getContext(),list));


        return view;

    }
}