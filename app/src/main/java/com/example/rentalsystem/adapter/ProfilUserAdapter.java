package com.example.rentalsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.R;
import com.example.rentalsystem.model.ProfilUserModel;

import java.util.List;

public class ProfilUserAdapter
        extends RecyclerView.Adapter<ProfilUserAdapter.UserViewHolder> {

    // ===== INTERFACE CLICK =====
    public interface OnItemClickListener {
        void onItemClick(ProfilUserModel item);
    }

    private final List<ProfilUserModel> list;
    private final OnItemClickListener listener;

    // ===== CONSTRUCTOR =====
    public ProfilUserAdapter(List<ProfilUserModel> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_profil_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        ProfilUserModel data = list.get(position);
        if (data == null) return;

        holder.menuTitle.setText(data.getTitle());
        holder.menuIcon.setImageResource(data.getIconRes());

        if (data.getStatus() != null && !data.getStatus().isEmpty()) {
            holder.menuStatus.setVisibility(View.VISIBLE);
            holder.menuStatus.setText(data.getStatus());
        } else {
            holder.menuStatus.setVisibility(View.GONE);
        }

        // ===== CLICK ITEM =====
        holder.itemView.setOnClickListener(v -> listener.onItemClick(data));
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    // ===== VIEW HOLDER =====
    static class UserViewHolder extends RecyclerView.ViewHolder {

        TextView menuTitle, menuStatus;
        ImageView menuIcon;

        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            menuTitle = itemView.findViewById(R.id.menuTitle);
            menuStatus = itemView.findViewById(R.id.menuStatus);
            menuIcon = itemView.findViewById(R.id.menuIcon);
        }
    }
}
