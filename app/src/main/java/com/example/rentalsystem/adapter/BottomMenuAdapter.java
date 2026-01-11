package com.example.rentalsystem.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
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

    // ================= LISTENER =================
    public interface OnMenuClickListener {
        void onMenuClick(int position);
    }

    private final List<MenuModel> menuList;
    private OnMenuClickListener listener;

    private final int activeColor = Color.parseColor("#135bec");
    private final int inactiveColor = Color.parseColor("#4c669a");

    // ================= CONSTRUCTOR UTAMA (PAKAI LISTENER) =================
    public BottomMenuAdapter(List<MenuModel> menuList, OnMenuClickListener listener) {
        this.menuList = menuList;
        this.listener = listener;
    }

    // ================= CONSTRUCTOR TAMBAHAN (TANPA LISTENER) =================
    // 👉 INI YANG MEMPERBAIKI ERROR KAMU
    public BottomMenuAdapter(List<MenuModel> menuList) {
        this.menuList = menuList;
        this.listener = null;
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
        MenuModel item = menuList.get(position);

        holder.tvTitle.setText(item.getTitle());
        holder.ivIcon.setImageResource(item.getIcon());

        int color = item.isActive() ? activeColor : inactiveColor;
        holder.tvTitle.setTextColor(color);
        holder.ivIcon.setColorFilter(color);
        holder.tvTitle.setTypeface(
                null,
                item.isActive() ? Typeface.BOLD : Typeface.NORMAL
        );

        if (holder.vIndicator != null) {
            holder.vIndicator.setVisibility(
                    item.isActive() ? View.VISIBLE : View.INVISIBLE
            );
        }

        holder.itemView.setOnClickListener(v -> {
            // Update active state
            for (MenuModel menu : menuList) {
                menu.setActive(false);
            }
            item.setActive(true);
            notifyDataSetChanged();

            // Callback ke Activity / Fragment (jika ada)
            if (listener != null) {
                listener.onMenuClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    // ================= VIEW HOLDER =================
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        View vIndicator;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.ivMenuIcon);
            tvTitle = itemView.findViewById(R.id.tvMenuTitle);
            vIndicator = itemView.findViewById(R.id.vIndicator);
        }
    }
}
