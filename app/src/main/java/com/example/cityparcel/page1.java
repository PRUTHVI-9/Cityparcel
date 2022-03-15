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

public class page1 extends Fragment {
    RecyclerView menulist_rv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page1,container,false);
        menulist_rv=view.findViewById(R.id.menulist_rv);

        menulist_rv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL ,false));

        List<Menu> list = new ArrayList<>();
        list.add(new Menu("Paneer Masala","&#8377 150","Serves 2","Paneer, prepared in tometo, Cashew,","& Creamy Gravy",R.drawable.panner));
        list.add(new Menu("Delux Vegetrain Thali","&#8377 200","Serves 2","Dal+Sabji+3Roti+Rice+Salad+Papad+","Achar+Curd/Raita+Sweet",R.drawable.delux));
        list.add(new Menu("Mughlai Paneer","&#8377 200","","Paneer+Tometoes in a rich white gravy, Cashew,","& Creamy Gravy",R.drawable.muglai));
        list.add(new Menu("Aloo Matar","&#8377 120","Serves 2","Carrot+Beans+Panner+Patatos+Capsicum","",R.drawable.aloo));
        list.add(new Menu("Veg Kholapuri","&#8377 180","Serves 1","Carrot+Beans+Panner+Patatos+Capsicum","1 Gulab Jamun",R.drawable.vegkholapuri));
        menulist_rv.setAdapter(new MenuCardAdapter(getContext(),list));
        menulist_rv.setNestedScrollingEnabled(false);
        return view;
    }

}
