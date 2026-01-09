package com.example.rentalsystem.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.rentalsystem.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.model.MenuProfilModel;

import java.util.List;

public class MenuProfilAdapter extends RecyclerView.Adapter<MenuProfilAdapter.ViewHolder> {
    private List<MenuProfilModel> menuList;

    public MenuProfilAdapter(List<MenuProfilModel> menuList) {
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MenuProfilAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu_profil, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MenuProfilModel item = menuList.get(position);

        holder.tvJudul.setText(item.getJudul());
        holder.tvSub.setText(item.getSubJudul());
        holder.ivIkon.setImageResource(item.getIkon());

        // Pastikan ivIkon di XML memiliki android:background agar tidak NullPointerException
        if (holder.ivIkon.getBackground() != null) {
            holder.ivIkon.getBackground().setColorFilter(Color.parseColor(item.getWarnaHex()), PorterDuff.Mode.SRC_IN);
        }

    }
    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvSub;
        ImageView ivIkon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tvMenu);
            tvSub = itemView.findViewById(R.id.tvSubMenu);
            ivIkon = itemView.findViewById(R.id.ivMenu);
        }
    }
}