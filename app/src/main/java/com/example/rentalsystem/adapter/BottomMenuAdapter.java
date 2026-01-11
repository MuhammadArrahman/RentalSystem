package com.example.rentalsystem.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.R;
import com.example.rentalsystem.model.MenuModel;

import java.util.List;

public class BottomMenuAdapter extends RecyclerView.Adapter<BottomMenuAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private final List<MenuModel> list;
    private final OnItemClickListener listener;

    private final int activeColor = Color.parseColor("#2970FF");
    private final int inactiveColor = Color.parseColor("#999999");

    public BottomMenuAdapter(List<MenuModel> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bottom_menu, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuModel item = list.get(position);

        // ✅ BENAR
        holder.tvMenuTitle.setText(item.getTitle());
        holder.ivMenuIcon.setImageResource(item.getIcon());

        int color = item.isActive() ? activeColor : inactiveColor;
        holder.ivMenuIcon.setColorFilter(color);
        holder.tvMenuTitle.setTextColor(color);
        holder.vIndicator.setVisibility(item.isActive() ? View.VISIBLE : View.INVISIBLE);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMenuIcon;
        TextView tvMenuTitle;
        View vIndicator;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMenuIcon = itemView.findViewById(R.id.ivMenuIcon);   // ✅ SESUAI XML
            tvMenuTitle = itemView.findViewById(R.id.tvMenuTitle); // ✅ SESUAI XML
            vIndicator = itemView.findViewById(R.id.vIndicator);
        }
    }
}
