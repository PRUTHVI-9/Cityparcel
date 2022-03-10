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

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewHolder> {
    Context context;
    List<ReviewClass>list;

    public ReviewAdapter(Context context, List<ReviewClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ReviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.review_row,parent,false);
        ReviewHolder reviewHolder=new ReviewHolder(view);
        return reviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewHolder holder, int position) {
        ReviewClass reviewClass=list.get(position);
        holder.customer_name.setText(reviewClass.getCustomer_name());
        holder.customer_review.setText(reviewClass.getReview());
        holder.customer_rating.setText(Html.fromHtml(reviewClass.getRating()));
        holder.review_details.setText(reviewClass.getReview_details());
        holder.customer_profile.setImageResource(reviewClass.getCustomer_profile());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ReviewHolder extends RecyclerView.ViewHolder {
        TextView review_details,customer_name,customer_review,customer_rating;
        ImageView customer_profile;
        public ReviewHolder(@NonNull View itemView) {
            super(itemView);
            customer_profile=itemView.findViewById(R.id.customer_profile);
            customer_name=itemView.findViewById(R.id.customer_name);
            review_details=itemView.findViewById(R.id.review_details);
            customer_review=itemView.findViewById(R.id.customer_review);
            customer_rating=itemView.findViewById(R.id.customer_rating);

        }
    }
}
