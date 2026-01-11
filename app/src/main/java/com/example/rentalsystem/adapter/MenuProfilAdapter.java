package com.example.rentalsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.R;
import com.example.rentalsystem.model.MenuProfilModel;

import java.util.List;

public class MenuProfilAdapter
        extends RecyclerView.Adapter<MenuProfilAdapter.ViewHolder> {

    public interface OnMenuClickListener {
        void onMenuClick(MenuProfilModel model);
    }

    private List<MenuProfilModel> list;
    private OnMenuClickListener listener;

    public MenuProfilAdapter(
            List<MenuProfilModel> list,
            OnMenuClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_menu_profil, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        MenuProfilModel item = list.get(position);

        holder.tvMenu.setText(item.getTitle());
        holder.tvSubMenu.setText(item.getSubtitle());
        holder.ivMenu.setImageResource(item.getIconRes());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onMenuClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivMenu;
        TextView tvMenu, tvSubMenu;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMenu = itemView.findViewById(R.id.ivMenu);
            tvMenu = itemView.findViewById(R.id.tvMenu);
            tvSubMenu = itemView.findViewById(R.id.tvSubMenu);
        }
    }
}
