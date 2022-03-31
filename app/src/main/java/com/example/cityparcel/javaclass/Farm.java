package com.example.cityparcel.javaclass;

public class Farm {
    String farm1;
    String farm2;
    int img;

    public Farm(String farm1, String farm2, int img) {
        this.farm1 = farm1;
        this.farm2 = farm2;
        this.img = img;
    }

    public String getFarm1() {
        return farm1;
    }

    public void setFarm1(String farm1) {
        this.farm1 = farm1;
    }

    public String getFarm2() {
        return farm2;
    }

    public void setFarm2(String farm2) {
        this.farm2 = farm2;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
