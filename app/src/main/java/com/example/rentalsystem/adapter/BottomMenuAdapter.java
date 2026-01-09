package com.example.rentalsystem.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.R;
import com.example.rentalsystem.ArmadaFragment; // Pastikan fragment Anda sudah ada
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

        // Update Warna & Style Aktif
        int color = item.isActive() ? activeColor : inactiveColor;
        holder.tvTitle.setTextColor(color);
        holder.ivIcon.setColorFilter(color);

        if (holder.vIndicator != null) {
            holder.vIndicator.setVisibility(item.isActive() ? View.VISIBLE : View.INVISIBLE);
        }
        holder.tvTitle.setTypeface(null, item.isActive() ? Typeface.BOLD : Typeface.NORMAL);

        // Fitur Klik Navigasi
        holder.itemView.setOnClickListener(v -> {
            // Update status aktif di list
            for (MenuModel menu : menuList) {
                menu.setActive(false);
            }
            item.setActive(true);
            notifyDataSetChanged();

            // Logika Pindah Fragment
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            if (item.getTitle().equalsIgnoreCase("Armada")) {
                loadFragment(activity, new ArmadaFragment());
            } else if (item.getTitle().equalsIgnoreCase("Verifikasi")) {
                // loadFragment(activity, new VerifikasiFragment()); // Jika sudah ada
            }
        });
    }

    // Metode untuk memuat Fragment
    private void loadFragment(AppCompatActivity activity, Fragment fragment) {
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment) // Ganti ke ID container di activity_main
                .commit();
    }
    @Override
    public int getItemCount() { return menuList.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        View vIndicator;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.ivMenuIcon);
            tvTitle = itemView.findViewById(R.id.tvMenuTitle);
            vIndicator = itemView.findViewById(R.id.vIndicator);
        }
    }
}