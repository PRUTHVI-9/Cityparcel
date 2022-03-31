package com.example.cityparcel.javaclass;

public class ReviewClass {
    String customer_name;
    String date;
    String rating;
    String review;
    String review_details;
    int customer_profile;

    public ReviewClass(String customer_name, String date, String rating, String review, String review_details, int customer_profile) {
        this.customer_name = customer_name;
        this.date = date;
        this.rating = rating;
        this.review = review;
        this.review_details = review_details;
        this.customer_profile = customer_profile;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReview_details() {
        return review_details;
    }

    public void setReview_details(String review_details) {
        this.review_details = review_details;
    }

    public int getCustomer_profile() {
        return customer_profile;
    }

    public void setCustomer_profile(int customer_profile) {
        this.customer_profile = customer_profile;
    }
}

