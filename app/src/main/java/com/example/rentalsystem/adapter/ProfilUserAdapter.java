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

public class ProfilUserAdapter extends RecyclerView.Adapter<ProfilUserAdapter.UserViewHolder> {
    private List<ProfilUserModel> list;

    public ProfilUserAdapter(List<ProfilUserModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profil_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        ProfilUserModel data = list.get(position);
        holder.tvTitle.setText(data.getTitle());
        holder.imgIcon.setImageResource(data.getIconRes());

        if (data.getStatus() != null) {
            holder.tvStatus.setVisibility(View.VISIBLE);
            holder.tvStatus.setText(data.getStatus());
        } else {
            holder.tvStatus.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() { return list.size(); }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvStatus;
        ImageView imgIcon;

        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvStatus = itemView.findViewById(R.id.tvStatusSewa);
            imgIcon = itemView.findViewById(R.id.imgCar);
        }
    }
}
