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

import com.example.cityparcel.javaclass.Menu;
import com.example.cityparcel.R;

import java.util.List;

public class MenuCardAdapter extends RecyclerView.Adapter<MenuCardAdapter.MenuHolder> {
    Context context;
    List<Menu> Menulist;

    public MenuCardAdapter(Context context, List<Menu> menulist) {
        this.context = context;
        Menulist = menulist;
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.menu_row,parent,false);
        MenuHolder holder=new MenuHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, int position) {
        Menu menu=Menulist.get(position);
        holder.dish_name.setText(menu.getDishname());
        holder.rupee.setText(Html.fromHtml(menu.getRupee()));
        holder.serves.setText(menu.getServes());
        holder.discription1.setText(menu.getDiscription1());
        holder.discription2.setText(menu.getDiscription2());
        holder.image.setImageResource(menu.getDishimage());


    }

    @Override
    public int getItemCount() {
        return Menulist.size();
    }

    public class MenuHolder extends RecyclerView.ViewHolder {
        TextView dish_name,rupee,serves,discription1,discription2;
        ImageView image;
        public MenuHolder(@NonNull View itemView) {
            super(itemView);
            dish_name=itemView.findViewById(R.id.dish_name);
            rupee=itemView.findViewById(R.id.rupee);
            serves=itemView.findViewById(R.id.serves);
            discription1=itemView.findViewById(R.id.discription1);
            discription2=itemView.findViewById(R.id.discription2);
            image=itemView.findViewById(R.id.menu_image);
        }

    }
}
