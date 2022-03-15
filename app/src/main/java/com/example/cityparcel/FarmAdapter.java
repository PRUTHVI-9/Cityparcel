package com.example.cityparcel;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FarmAdapter extends RecyclerView.Adapter<FarmAdapter.FarmHolder> {
    Context context;
    List<Farm> list;

    public FarmAdapter(Context context, List<Farm> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FarmAdapter.FarmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_row5,parent,false);
        FarmHolder farmHolder = new FarmHolder(view);
        return farmHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FarmAdapter.FarmHolder holder, int position) {
        Farm farm=list.get(position);
        holder.imageView.setImageResource(farm.getImg());
        holder.tv.setText(farm.getFarm1());
        holder.tv1.setText(Html.fromHtml(farm.getFarm2()));
        holder.favorite3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.favorite3.getDrawable().getConstantState()==
                context.getResources().getDrawable(R.drawable.ic_baseline_favorite_red).getConstantState()){
                    holder.favorite3.setImageResource(R.drawable.ic_favorite);
                }else {
                    holder.favorite3.setImageResource(R.drawable.ic_baseline_favorite_red);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FarmHolder extends RecyclerView.ViewHolder {
        TextView tv,tv1;
        ImageView imageView;
        ImageView favorite3;
        public FarmHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.farmimage);
            favorite3=itemView.findViewById(R.id.favorite3);
            tv=itemView.findViewById(R.id.farmpro);
            tv1=itemView.findViewById(R.id.kg);
        }
    }
}
