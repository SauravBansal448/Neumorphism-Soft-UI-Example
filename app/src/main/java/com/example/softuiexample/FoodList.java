package com.example.softuiexample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FoodList implements Serializable {

    public String name;
    public int image;


    public static List<FoodList> getFoodData(){

        List<FoodList> data = new ArrayList<>();

        FoodList mi = new FoodList();

        mi.name = "Italian";
        mi.image= R.drawable.italian;
        data.add(mi);

        FoodList m2= new FoodList();

        m2.name = "Mexican";
        m2.image= R.drawable.mexican;
        data.add(m2);

        FoodList m3 = new FoodList();

        m3.name = "Indian";
        m3.image= R.drawable.salad;

        data.add(m3);

        return data;
    }
}
