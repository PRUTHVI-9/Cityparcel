package com.example.cityparcel.adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityparcel.javaclass.NonvegClass;
import com.example.cityparcel.R;
import com.example.cityparcel.activity.HomeActivity;
import com.example.cityparcel.fragments.RestaurantDetailsFragment;

import java.util.List;

public class NonvegAdapter extends RecyclerView.Adapter<NonvegAdapter.NonVegHolder> {
    Context context;
    List<NonvegClass> list;

    public NonvegAdapter(Context context, List<NonvegClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NonVegHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_row4, parent, false);
        NonVegHolder holder = new NonVegHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NonVegHolder holder, int position) {
        NonvegClass nonvegClass = list.get(position);
        holder.textView1.setText(nonvegClass.getNonveg1());
        holder.textView2.setText(nonvegClass.getNonveg2());
        holder.textView3.setText(Html.fromHtml(nonvegClass.getNonveg3()));
        holder.textView4.setText(nonvegClass.getNonveg4());
        holder.imageView.setImageResource(nonvegClass.getNonimage());
        holder.favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.favorite.getDrawable().getConstantState() ==
                        context. getResources().getDrawable(R.drawable.ic_baseline_favorite_red).getConstantState()){
                    holder.favorite.setImageResource(R.drawable.ic_favorite);
                } else{
                    holder.favorite.setImageResource(R.drawable.ic_baseline_favorite_red);
                }
            }
        });

        holder.card.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("title", nonvegClass.getNonveg1());
                bundle.putString("discription", nonvegClass.getNonveg2());
                bundle.putInt("image", nonvegClass.getNonimage());

                RestaurantDetailsFragment restaurantDetailsFragment = new RestaurantDetailsFragment();
                restaurantDetailsFragment.setArguments(bundle);

                ((HomeActivity) context).getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe1, restaurantDetailsFragment, null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NonVegHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ImageView imageView, favorite;
        CardView card;

        public NonVegHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.test3);
            textView2 = itemView.findViewById(R.id.test4);
            textView3 = itemView.findViewById(R.id.test5);
            textView4 = itemView.findViewById(R.id.timing);
            imageView = itemView.findViewById(R.id.image2);
            favorite = itemView.findViewById(R.id.favorite);
            card = itemView.findViewById(R.id.card);
        }
    }
}
