package com.example.cityparcel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class page3 extends Fragment {
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page3,container,false);
        recyclerView=view.findViewById(R.id.review);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL ,false));


        List<ReviewClass> list =new ArrayList();
        list.add(new ReviewClass("Pankaj Jadhav","10 march 2022","&#9733&#9733&#9733&#9733&#9734","Food is really amazing","We visited twice this restaurant while our stay at vythri village resort.",R.drawable.pj));
        list.add(new ReviewClass("Pruthvi Yadav","10 march 2022","&#9733&#9733&#9733&#9734&#9734","Food is really good","The Food we had enjoyed at the time of dinner. It was really delicious taste with great quality",R.drawable.py));
        list.add(new ReviewClass("Pankaj Jadhav","10 march 2022","&#9733&#9733&#9733&#9733&#9734","Food is really amazing","The Food we had enjoy",R.drawable.pj1));
        list.add(new ReviewClass("Pruthvi Yadav","10 march 2022","&#9733&#9733&#9733&#9733&#9734","Food is really like a Wow","Nice arrangement and services from the staff while eating, we found nothing bad about this hotel.",R.drawable.py));
        recyclerView.setAdapter(new ReviewAdapter(getContext(),list));
        return view;
    }

}
