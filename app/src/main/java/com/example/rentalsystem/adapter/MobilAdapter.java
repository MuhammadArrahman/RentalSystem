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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mobil, parent, false);
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

        // Logika perubahan warna Badge Status berdasarkan data
        String status = mobil.getStatus().toLowerCase();
        if (status.equals("tersedia")) {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_status_tersedia);
            holder.tvStatus.setTextColor(Color.parseColor("#12B76A")); // Hijau
        } else if (status.equals("disewa")) {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_status_disewa);
            holder.tvStatus.setTextColor(Color.parseColor("#175CD3")); // Biru
        } else if (status.equals("servis")) {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_status_servis);
            holder.tvStatus.setTextColor(Color.parseColor("#B54708")); // Orange
        }
    }

    @Override
    public int getItemCount() {
        return mobilList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMerk, tvTipe, tvPlat, tvHarga, tvStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMerk = itemView.findViewById(R.id.tvMerk);
            tvTipe = itemView.findViewById(R.id.tvTipe);
            tvPlat = itemView.findViewById(R.id.tvPlat);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }
}