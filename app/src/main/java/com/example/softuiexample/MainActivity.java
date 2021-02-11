package com.example.softuiexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.basel.neumorphism.Neu;
import com.basel.neumorphism.ViewShape;
import com.example.softuiexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        int backgroundColor = ContextCompat.getColor(this, R.color.colorPrimary);
        int controlColor = ContextCompat.getColor(this, R.color.colorPrimaryDark);

        new Neu(this, true)
                .with(ui.etUserName, ui.etPassword, ui.btnLogin)
                .parentColor(backgroundColor)
                .controlColor(controlColor)
                .withRoundedCorners(20)
                .neuIt();

        new Neu(this, true)
                .with(ui.btnRecyclerView, ui.btnFoodUI)
                .parentColor(backgroundColor)
                .controlColor(controlColor)
                .withRoundedCorners(20)
                .viewShape(ViewShape.VIEW_SHAPE_CIRCULAR)
                .neuIt();

        ui.btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        });

        ui.btnFoodUI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FoodUIActivity.class));
            }
        });
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
