package com.example.softuiexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.basel.neumorphism.Neu;
import com.example.softuiexample.databinding.AdapterMyEventBinding;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context mCtx;
    private List<EmployeeList> employeeLists;

    public ListAdapter(Context mCtx) {
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterMyEventBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.adapter_my_event, parent, false);

        return new ListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        int backgroundColor = ContextCompat.getColor(mCtx, R.color.colorPrimary);
        int controlColor = ContextCompat.getColor(mCtx, R.color.colorPrimaryDark);

        new Neu(mCtx, true).with(holder.itemView)
                .parentColor(ContextCompat.getColor(mCtx, R.color.colorPrimary))
                .clipChildren(holder.binding.ivEventImage)
                .withRoundedCorners(30)
                .neuIt();

        holder.bind(employeeLists.get(position), position);

        // new Neu(mCtx, true).with(holder.binding.civFirstGoing, holder.binding.civSecondGoing).neuIt();

       /* new Neu(mCtx, true).with(holder.binding.tvCount)
                .parentColor(backgroundColor)
                .controlColor(controlColor)
                .Elevation(10)
                .withRoundedCorners(20)
                .neuIt();*/

       /* new Neu(mCtx, true).with(holder.binding.tvDate, holder.binding.tvEventLocation)
                .parentColor(backgroundColor)
                .controlColor(controlColor)
                .Elevation(3)
                .neuIt();*/
    }

    public void setData(List<EmployeeList> employeeLists) {
        this.employeeLists = employeeLists;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return employeeLists == null ? 0 : employeeLists.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        private final AdapterMyEventBinding binding;

        public ListViewHolder(@NonNull AdapterMyEventBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void bind(EmployeeList employeeList, int position) {
            if (employeeList != null) {
                binding.tvEmpName.setText(employeeList.getName());
                binding.tvDesignation.setText(employeeList.getDesignation());
            }

        }
    }
}
