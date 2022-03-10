package com.example.cityparcel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class page2 extends Fragment {
    RecyclerView photo;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page2,container,false);
        photo=view.findViewById(R.id.photo);

        photo.setLayoutManager(new GridLayoutManager(getContext(),3));

        List<PhotoClass>list=new ArrayList<>();
        list.add(new PhotoClass(R.drawable.panner));
        list.add(new PhotoClass(R.drawable.vegkholapuri));
        list.add(new PhotoClass(R.drawable.muglai));
        list.add(new PhotoClass(R.drawable.aloo));
        list.add(new PhotoClass(R.drawable.pankaj));
        list.add(new PhotoClass(R.drawable.vanita));
        list.add(new PhotoClass(R.drawable.mauli));
        list.add(new PhotoClass(R.drawable.malhar));
        list.add(new PhotoClass(R.drawable.homemade));
        list.add(new PhotoClass(R.drawable.resto2));
        list.add(new PhotoClass(R.drawable.resto3));
        list.add(new PhotoClass(R.drawable.resto4));
        list.add(new PhotoClass(R.drawable.basefood));
        list.add(new PhotoClass(R.drawable.kunal));
        list.add(new PhotoClass(R.drawable.pooja));
        list.add(new PhotoClass(R.drawable.potoba));
        list.add(new PhotoClass(R.drawable.adisha));
        photo.setAdapter(new PhotoAdapter(getContext(),list));



        return view;
    }

}
