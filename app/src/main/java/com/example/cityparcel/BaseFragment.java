package com.example.cityparcel;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class BaseFragment extends Fragment {
RecyclerView recyclerView,restolist,homemadefood,farm,gift,carrer;
TextView viewall1,viewall2,viewall3,viewall4;
LinearLayout restofood,homefood,farmproducts,giftitems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        recyclerView = view.findViewById(R.id.foodlist);
        restolist = view.findViewById(R.id.foodlist2);
        homemadefood = view.findViewById(R.id.foodlist3);
        restofood = view.findViewById(R.id.restofood);
        homefood = view.findViewById(R.id.home_made);
        farmproducts = view.findViewById(R.id.farmpro);
        giftitems = view.findViewById(R.id.gift);
        farm = view.findViewById(R.id.foodlist4);
        gift = view.findViewById(R.id.foodlist5);
        carrer = view.findViewById(R.id.foodlist6);
        viewall1 = view.findViewById(R.id.view1);
        viewall2 = view.findViewById(R.id.view2);
        viewall3 = view.findViewById(R.id.view3);
        viewall4 = view.findViewById(R.id.view4);

        viewall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe1, new RestaurantFragment(),null)
                        .commit();
            }
        });
        restofood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe1,new RestaurantFragment(),null)
                        .commit();
            }
        });
        viewall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe1,new NonVegFragment(),null)
                        .commit();
            }
        });
        homefood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe1,new NonVegFragment(),null)
                        .commit();
            }
        });
        viewall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe1,new FarmFragment(),null)
                        .commit();
            }
        });
        farmproducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe1,new FarmFragment(),null)
                        .commit();
            }
        });
        viewall4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe1,new FarmFragment(),null)
                        .commit();
            }
        });
        giftitems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe1,Gift_ItemsFragment.class,null)
                        .commit();
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        restolist.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        homemadefood.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        farm.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        gift.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        carrer.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));




        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.resto2);
        list.add(R.drawable.resto3);
        list.add(R.drawable.resto4);
        list.add(R.drawable.homemade);
        list.add(R.drawable.basefood);
        list.add(R.drawable.farm);
        list.add(R.drawable.gift);
        recyclerView.setAdapter(new FoodAdapter(getContext(),list));

        List<Restaurant> list2 = new ArrayList<>();
        list2.add(new Restaurant("Gavran Hotel","special tambda pandra Special Kholapuri misal","10 min",4.5,R.drawable.gavran));
        list2.add(new Restaurant("Gajanan Vadapav","One of the best and finest vada pavs in thane since 1978 ","5 min",4.5,R.drawable.gajanan));
        list2.add(new Restaurant("KFC","It’s finger lickin’ good Nobody does chicken like KFC","10 min",4.5,R.drawable.kfc));
        list2.add(new Restaurant("Prashant Sweetcorner","1 bar chake toh dekho","15 min",4.5,R.drawable.prashant));
        list2.add(new Restaurant("Pizza Hut","The Best Pizzas Under One Roof. ","10 min",4.5,R.drawable.pizzahut));
        list2.add(new Restaurant("Potoba","Special franky","20 min",4.5,R.drawable.potoba));
        list2.add(new Restaurant("Kunj Vihar","Special Vadapav","10 min",4.5,R.drawable.kunjvihar));
        restolist.setAdapter(new RestolistAdapter(getContext(),list2));

        List<Restaurant> list3 = new ArrayList<>();
        list3.add(new Restaurant("Zunka bhakar","Jajanit Zunka bhakar","10 min",4.5,R.drawable.zunka));
        list3.add(new Restaurant("Adisha Tiffin Service","Home-made food… no compromise with health.","5 min",4.5,R.drawable.tiffin));
        list3.add(new Restaurant("Kunal's Dabba","Eat healthily. Live healthily","10 min",4.5,R.drawable.kunal));
        list3.add(new Restaurant("Vanita Lunch Home","Home-made food that make your tummy go yummy.","15 min",4.5,R.drawable.vanita));
        list3.add(new Restaurant("Pooja Lunch home","Eat well. Live well.","10 min",4.5,R.drawable.pooja));
        list3.add(new Restaurant("Mauli Polibhaji kendra","Home-made food tastes divine.","20 min",4.5,R.drawable.mauli));
        list3.add(new Restaurant("Sugran polibhaji kendra","Wow taste… wow health.","10 min",4.5,R.drawable.sugran));
        homemadefood.setAdapter(new RestolistAdapter(getContext(),list3));

        List<Restaurant2> list4 = new ArrayList<>();
        list4.add(new Restaurant2("Fresh Farm Grapes","&#8377 50/kg",R.drawable.grapes));
        list4.add(new Restaurant2("Fresh Strawberry","&#837 100/kg7",R.drawable.strawberry));
        list4.add(new Restaurant2("Fresh Mango","&#8377 250/kg",R.drawable.mango));
        list4.add(new Restaurant2("Fresh Farm Banana","&#8377 30/dozen",R.drawable.bananas));
        list4.add(new Restaurant2("Fresh Oranges","&#8377 150/kg",R.drawable.oranges));
        list4.add(new Restaurant2("Fresh Apples","&#8377 200/kg",R.drawable.apples));
        farm.setAdapter(new FarmGiftAdapter(getContext(),list4));

        List<Restaurant2> list5 = new ArrayList<>();
        list5.add(new Restaurant2("Wooden Toy","&#8377 50",R.drawable.wooden));
        list5.add(new Restaurant2("Handmade Painting","&#8377 100",R.drawable.handmade));
        list5.add(new Restaurant2("The Craft Store ","&#8377 250",R.drawable.craft));
        list5.add(new Restaurant2("Priented Mug shop","&#8377 30",R.drawable.mug));
        list5.add(new Restaurant2("Soft Teddy Shop","&#8377 150",R.drawable.teddy));
        list5.add(new Restaurant2("Bottle Planter Shop","&#8377 200",R.drawable.bottle));
        list5.add(new Restaurant2("Statue Shop","&#8377 200",R.drawable.gift1));
        list5.add(new Restaurant2("All In One Gifts Shop","&#8377 200",R.drawable.gift2));
        gift.setAdapter(new FarmGiftAdapter(getContext(),list5));

        List<CarrerOportunity> list6 = new ArrayList<>();
       list6.add(new CarrerOportunity("Work from home(full time)","Join our new hotel",R.drawable.hotel));
       list6.add(new CarrerOportunity("Certified Chef(full time)","Join our new hotel",R.drawable.hotel2));
       list6.add(new CarrerOportunity("New Hotel","Join our new hotel",R.drawable.hotel3));
        carrer.setAdapter(new CarrerAdapter(getContext(),list6));
        carrer.setNestedScrollingEnabled(false);

        return view;
    }
}