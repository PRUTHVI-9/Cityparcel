package com.example.cityparcel.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cityparcel.adapter.NonvegAdapter;
import com.example.cityparcel.javaclass.NonvegClass;
import com.example.cityparcel.R;

import java.util.ArrayList;
import java.util.List;


public class NonVegFragment extends Fragment {
    RecyclerView nonfood;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_non_veg, container, false);
        nonfood = view.findViewById(R.id.nonfood);

        nonfood.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL ,false));

        List<NonvegClass> list = new ArrayList<>();
        list.add(new NonvegClass("Adisha Tiffin Service","Wow taste… wow health.","&#8377 200 for one","10-20 min",R.drawable.adisha));
        list.add(new NonvegClass("Special Zunka bhakar","janjanit zunka bhakar","&#8377 100 for one","10-20 min",R.drawable.zunka));
        list.add(new NonvegClass("Vanita Tiffin Service","Your personal chef","&#8377 190 for one","10-20 min",R.drawable.vanita));
        list.add(new NonvegClass("Aarti Homemade Foods","Eat all you want","&#8377 220 for one","10-20 min",R.drawable.aarti));
        list.add(new NonvegClass("Malhar Lunch Home","Food that reminds you of your home","&#8377 200 for one","10-20 min",R.drawable.malhar));
        list.add(new NonvegClass("Shivraj Lunch Home","Pleasantly homely","&#8377 250 for one","10-20 min",R.drawable.shivraj));
        list.add(new NonvegClass("Pankaj Homemade Foods","Getting homely meal is a great deal.","&#8377 180 for one","10-20 min",R.drawable.pankaj));
        nonfood.setAdapter(new NonvegAdapter(getContext(),list));
        nonfood.setNestedScrollingEnabled(false);

        return view;
    }
}