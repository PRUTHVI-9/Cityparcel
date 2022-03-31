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


public class RestaurantFragment extends Fragment {
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_restaurant, container, false);

       recyclerView = view.findViewById(R.id.resto_food);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL ,false));

        List<NonvegClass> list = new ArrayList<>();
        list.add(new NonvegClass("The Yellow Chilli","Fish curry, Prawns koliwada","&#8377 200 for one","10-20 min",R.drawable.yellow));
        list.add(new NonvegClass("The Caravan Menu","Butter garlic crab, Kheema pao","&#8377 190 for one","10-20 min",R.drawable.carvan));
        list.add(new NonvegClass("Hotel Triveni ","Brun Maska, Chicken mayo roll","&#8377 220 for one","10-20 min",R.drawable.triveni));
        list.add(new NonvegClass("The Food Studio","The Bombay sandwich,Bheja Fry, Sizzlers","&#8377 200 for one","10-20 min",R.drawable.foodstudio));
        list.add(new NonvegClass("MUMBAI MASALA","Butter Chicken, VaranBhaat, Kebabs","&#8377 250 for one","10-20 min",R.drawable.mumbai));
        list.add(new NonvegClass("Barbeque Nation","Boneless Chicken, Biryani, Prawns","&#8377 1000 for all","10-20 min",R.drawable.barbeque));
        recyclerView.setAdapter(new NonvegAdapter(getContext(),list));


//        recyclerView.setNestedScrollingEnabled(false);

        return view;
    }
}