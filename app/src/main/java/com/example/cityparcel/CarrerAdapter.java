package com.example.cityparcel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarrerAdapter extends RecyclerView.Adapter<CarrerAdapter.MyHolder> {
    Context context;
    List<CarrerOportunity> list;

    public CarrerAdapter(Context context, List<CarrerOportunity> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CarrerAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.card_row3,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarrerAdapter.MyHolder holder, int position) {
        CarrerOportunity carrers =list.get(position);
        holder.imageView.setImageResource(carrers.getImage());
        holder.text1.setText(carrers.getTitle1());
        holder.text2.setText(carrers.getTitle2());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView text1,text2;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_image);
            text1 = itemView.findViewById(R.id.test1);
            text2 = itemView.findViewById(R.id.test2);
        }
    }
}
