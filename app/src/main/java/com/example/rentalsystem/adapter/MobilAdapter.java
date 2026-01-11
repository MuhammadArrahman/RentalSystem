package com.example.rentalsystem.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.R;
import com.example.rentalsystem.model.MobilModel;

import java.util.List;

public class MobilAdapter extends RecyclerView.Adapter<MobilAdapter.ViewHolder> {

    private List<MobilModel> mobilList;

    public MobilAdapter(List<MobilModel> mobilList) {
        this.mobilList = mobilList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mobil, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MobilModel mobil = mobilList.get(position);

        holder.tvMerk.setText(mobil.getMerk());
        holder.tvTipe.setText(mobil.getTipe());
        holder.tvPlat.setText(mobil.getPlat());
        holder.tvHarga.setText(mobil.getHarga());
        holder.tvStatus.setText(mobil.getStatus());

        // 🎨 WARNA STATUS
        String status = mobil.getStatus().toLowerCase();

        switch (status) {
            case "tersedia":
                holder.tvStatus.setTextColor(Color.parseColor("#12B76A")); // hijau
                break;

            case "disewa":
                holder.tvStatus.setTextColor(Color.parseColor("#F79009")); // oranye
                break;

            case "servis":
                holder.tvStatus.setTextColor(Color.parseColor("#D92D20")); // merah
                break;

            default:
                holder.tvStatus.setTextColor(Color.GRAY);
        }
    }

    @Override
    public int getItemCount() {
        return mobilList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvMerk, tvTipe, tvPlat, tvHarga, tvStatus;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMerk   = itemView.findViewById(R.id.tvMerk);
            tvTipe   = itemView.findViewById(R.id.tvTipe);
            tvPlat   = itemView.findViewById(R.id.tvPlat);
            tvHarga  = itemView.findViewById(R.id.tvHarga);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }
}
