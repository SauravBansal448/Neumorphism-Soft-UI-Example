package com.example.softuiexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.basel.neumorphism.Neu;
import com.basel.neumorphism.ViewShape;
import com.example.softuiexample.databinding.ActivityFoodUIBinding;

import java.util.List;

public class FoodUIActivity extends AppCompatActivity {

    private ActivityFoodUIBinding ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = DataBindingUtil.setContentView(FoodUIActivity.this, R.layout.activity_food_u_i);
        int backgroundColor = ContextCompat.getColor(this, R.color.colorPrimary);
        int controlColor = ContextCompat.getColor(this, R.color.colorPrimaryDark);
        initUI();

        new Neu(this, true)
                .with(ui.edtSearch)
                .parentColor(backgroundColor)
                .controlColor(controlColor)
                .withRoundedCorners(24)
                .neuIt();

        new Neu(this, true)
                .with(ui.ivProfile)
                .parentColor(backgroundColor)
                .controlColor(controlColor)
                .withRoundedCorners(50)
                .neuIt();

        new Neu(this, true)
                .with(ui.ibHamBurger)
                .viewShape(ViewShape.VIEW_SHAPE_CIRCULAR)
                .parentColor(backgroundColor)
                .controlColor(controlColor)
                .withCurvedSurface()
                .neuIt();

        new Neu(this, true).with(ui.llView)
                .parentColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .withRoundedCorners(20)
                .neuIt();

        new Neu(this, true)
                .with( ui.btnAdd)
                .parentColor(backgroundColor)
                .controlColor(controlColor)
                .withRoundedCorners(20)
                .neuIt();

        new Neu(this, true)
                .with( ui.toggleSwitch, ui.toggleButton, ui.checkBox, ui.radioButton)
                .parentColor(backgroundColor)
                .controlColor(controlColor)
                .withRoundedCorners(24)
                .neuIt();
    }

    private void initUI() {
        List<FoodList> data = FoodList.getFoodData();
        FoodAdapter adapter = new FoodAdapter(this);
        ui.recyclerView.setHasFixedSize(true);//every item of the RecyclerView has a fix size
        ui.recyclerView.setAdapter(adapter);
        adapter.setData(data);
    }
}
