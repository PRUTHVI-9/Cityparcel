package com.example.cityparcel;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RestolistAdapter extends RecyclerView.Adapter<RestolistAdapter.MyViewHolder> {
    Context context;
    List<Restaurant>list;
    private String TAG=getClass().getSimpleName();

    public RestolistAdapter(Context context, List<Restaurant> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_row,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Restaurant restaurant=list.get(position);
        holder.title.setText(restaurant.getTitle());
        holder.discription.setText(restaurant.getDiscription());
//        holder.rating.setText(restaurant.getRating());
        holder.time.setText(restaurant.getDelivery_time());
        holder.imageView.setImageResource(restaurant.getImage());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: "+restaurant.getTitle() );
                Bundle bundle = new Bundle();
                bundle.putString("title",restaurant.getTitle());
                bundle.putString("discription",restaurant.getDiscription());
                bundle.putString("time",restaurant.getDelivery_time());
                bundle.putInt("image", restaurant.getImage());

                RestaurantDetailsFragment restaurantDetailsFragment = new RestaurantDetailsFragment();
                restaurantDetailsFragment.setArguments(bundle);

                ((HomeActivity)context).getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.homeframe1,restaurantDetailsFragment,null)
                        .commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,discription,rating,time;
        CardView card;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageIcon);
            title = itemView.findViewById(R.id.title);
            discription = itemView.findViewById(R.id.description);
            rating = itemView.findViewById(R.id.rating);
            time = itemView.findViewById(R.id.min);
            card = itemView.findViewById(R.id.resto_card);

        }


    }
}
