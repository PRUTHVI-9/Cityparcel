package com.example.cityparcel;

public class Menu {
    String dishname;
    String rupee;
    String serves;
    String discription1;
    String discription2;
    int dishimage;

    public Menu(String dishname, String rupee, String serves, String discription1, String discription2, int dishimage) {
        this.dishname = dishname;
        this.rupee = rupee;
        this.serves = serves;
        this.discription1 = discription1;
        this.discription2 = discription2;
        this.dishimage = dishimage;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getRupee() {
        return rupee;
    }

    public void setRupee(String rupee) {
        this.rupee = rupee;
    }

    public String getServes() {
        return serves;
    }

    public void setServes(String serves) {
        this.serves = serves;
    }

    public String getDiscription1() {
        return discription1;
    }

    public void setDiscription1(String discription1) {
        this.discription1 = discription1;
    }

    public String getDiscription2() {
        return discription2;
    }

    public void setDiscription2(String discription2) {
        this.discription2 = discription2;
    }

    public int getDishimage() {
        return dishimage;
    }

    public void setDishimage(int dishimage) {
        this.dishimage = dishimage;
    }
}
