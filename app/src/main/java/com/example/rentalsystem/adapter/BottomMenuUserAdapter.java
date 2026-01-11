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
import com.example.rentalsystem.model.BottomMenuUserModel;

import java.util.List;

public class BottomMenuUserAdapter
        extends RecyclerView.Adapter<BottomMenuUserAdapter.ViewHolder> {

    private final List<BottomMenuUserModel> list;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public BottomMenuUserAdapter(@NonNull List<BottomMenuUserModel> list,
                                 @NonNull OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bottom_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BottomMenuUserModel item = list.get(position);
        if (item == null) return;

        // Set data
        holder.tvMenuTitle.setText(item.getTitle());
        holder.ivMenuIcon.setImageResource(item.getIcon());

        int activeColor = Color.parseColor("#135bec");
        int inactiveColor = Color.parseColor("#9CA3AF");

        if (item.isActive()) {
            holder.ivMenuIcon.setColorFilter(activeColor);
            holder.tvMenuTitle.setTextColor(activeColor);
            holder.vIndicator.setVisibility(View.VISIBLE);
        } else {
            holder.ivMenuIcon.setColorFilter(inactiveColor);
            holder.tvMenuTitle.setTextColor(inactiveColor);
            holder.vIndicator.setVisibility(View.INVISIBLE);
        }

        holder.itemView.setOnClickListener(v -> listener.onItemClick(position));
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    // ================= VIEW HOLDER =================
    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivMenuIcon;
        TextView tvMenuTitle;
        View vIndicator;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivMenuIcon = itemView.findViewById(R.id.ivMenuIcon);
            tvMenuTitle = itemView.findViewById(R.id.tvMenuTitle);
            vIndicator = itemView.findViewById(R.id.vIndicator);
        }
    }
}
