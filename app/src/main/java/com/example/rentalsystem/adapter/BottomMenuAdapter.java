package com.example.rentalsystem.adapter;

import android.graphics.Color;
import android.graphics.Typeface; // Import ditambahkan
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
    private List<MenuModel> menuList;
    private int activeColor = Color.parseColor("#135bec");
    private int inactiveColor = Color.parseColor("#4c669a");

    public BottomMenuAdapter(List<MenuModel> menuList) {
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bottom_menu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuModel item = menuList.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.ivIcon.setImageResource(item.getIcon());

        // Logika warna aktif/tidak aktif
        int color = item.isActive() ? activeColor : inactiveColor;
        holder.tvTitle.setTextColor(color);
        holder.ivIcon.setColorFilter(color);

        // IMPLEMENTASI BARU: Tampilkan garis biru jika aktif
        if (holder.vIndicator != null) {
            holder.vIndicator.setVisibility(item.isActive() ? View.VISIBLE : View.INVISIBLE);
        }

        // IMPLEMENTASI BARU: Bold text jika aktif
        holder.tvTitle.setTypeface(null, item.isActive() ? Typeface.BOLD : Typeface.NORMAL);

        // Tambahkan fitur klik agar menu bisa berpindah posisi aktif
        holder.itemView.setOnClickListener(v -> {
            for (MenuModel menu : menuList) {
                menu.setActive(false);
            }
            item.setActive(true);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() { return menuList.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        View vIndicator; // Tambahkan variabel untuk view garis

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.ivMenuIcon);
            tvTitle = itemView.findViewById(R.id.tvMenuTitle);
            vIndicator = itemView.findViewById(R.id.vIndicator); // Hubungkan ke ID di XML
        }
    }
}