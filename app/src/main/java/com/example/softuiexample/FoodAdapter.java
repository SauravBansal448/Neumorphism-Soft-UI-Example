package com.example.softuiexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.basel.neumorphism.Neu;
import com.example.softuiexample.databinding.FoodAdapterUiBinding;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private final Context mCtx;
    private List<FoodList> data;

    public FoodAdapter(Context mCtx) {
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FoodAdapterUiBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.food_adapter_ui, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.bind(data.get(position), position);

        new Neu(mCtx, true).with(holder.itemView)
                .parentColor(ContextCompat.getColor(mCtx, R.color.colorPrimary))
                .clipChildren(holder.binding.ivFood)
                .withRoundedCorners(45)
                .withCurvedSurface()
                .neuIt();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Neu(mCtx, true).with(holder.itemView)
                        .withRoundedCorners(45)
                        .withCurvedSurface()
                        .withBorders(3)
                        .neuIt();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setData(List<FoodList> data) {
        this.data = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final FoodAdapterUiBinding binding;

        public ViewHolder(FoodAdapterUiBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(FoodList foodList, int position) {
            if (foodList != null) {
                binding.ivFood.setImageResource(foodList.image);
                binding.tvFoodName.setText(foodList.name);
            }
        }
    }
}
