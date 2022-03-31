package com.example.cityparcel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityparcel.javaclass.PhotoClass;
import com.example.cityparcel.R;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder> {
    Context context;
    List<PhotoClass>list;

    public PhotoAdapter(Context context, List<PhotoClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view= LayoutInflater.from(context).inflate(R.layout.photo_row,parent,false);
        PhotoHolder photoHolder = new PhotoHolder(view);
        return photoHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
        PhotoClass photoClass =list.get(position);
        holder.image.setImageResource(photoClass.getImage());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PhotoHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public PhotoHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.photo_image);
        }
    }
}
