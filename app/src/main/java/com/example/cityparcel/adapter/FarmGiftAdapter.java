package com.example.cityparcel.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityparcel.R;
import com.example.cityparcel.javaclass.Restaurant2;

import java.util.List;

public class FarmGiftAdapter extends RecyclerView.Adapter<FarmGiftAdapter.MyCustomViewHolder> {
    Context context;
    List<Restaurant2> list2;


    public FarmGiftAdapter(Context context, List<Restaurant2> list2) {
        this.context = context;
        this.list2 = list2;
    }

    @NonNull
    @Override
    public FarmGiftAdapter.MyCustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_row2,parent,false);
        MyCustomViewHolder myCustomViewHolder = new MyCustomViewHolder(view);
        return myCustomViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FarmGiftAdapter.MyCustomViewHolder holder, int position) {
        Restaurant2 resto = list2.get(position);
        holder.textView1.setText(resto.getTitle());
        holder.textView2.setText(Html.fromHtml(resto.getTitle2()));
        holder.imageView.setImageResource(resto.getImage());
        holder.favorite1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.favorite1.getDrawable().getConstantState() ==
                context.getResources().getDrawable(R.drawable.ic_baseline_favorite_red).getConstantState()){
                    holder.favorite1.setImageResource(R.drawable.ic_favorite);
                }else{
                    holder.favorite1.setImageResource(R.drawable.ic_baseline_favorite_red);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public class MyCustomViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageView favorite1;
        TextView textView1,textView2;
        public MyCustomViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image1);
            favorite1 = itemView.findViewById(R.id.favorite1);
            textView1 = itemView.findViewById(R.id.farmproduct);
            textView2 = itemView.findViewById(R.id.kilogram);
        }
    }
}
