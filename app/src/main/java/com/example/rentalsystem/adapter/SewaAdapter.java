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
import com.example.rentalsystem.model.SewaModel;
import java.util.List;

public class SewaAdapter extends RecyclerView.Adapter<SewaAdapter.ViewHolder> {
    private List<SewaModel> sewaList;

    public SewaAdapter(List<SewaModel> sewaList) {
        this.sewaList = sewaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Pastikan nama file layout ini benar
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sewa_terbaru, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SewaModel item = sewaList.get(position);

        holder.tvMobil.setText(item.getNamaMobil());
        holder.tvDetail.setText(item.getPenyewa() + " • " + item.getDurasi());
        holder.tvJam.setText(item.getJam());
        holder.tvStatus.setText(item.getStatus());
        holder.ivMobil.setImageResource(item.getIconMobil());

        // Penyesuaian warna badge secara dinamis sesuai gambar
        if (item.getStatus().equalsIgnoreCase("Berjalan")) {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_badge_green);
            holder.tvStatus.setTextColor(Color.parseColor("#2E7D32"));
        } else if (item.getStatus().equalsIgnoreCase("Pending")) {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_badge_orange);
            holder.tvStatus.setTextColor(Color.parseColor("#EF6C00"));
        } else if (item.getStatus().equalsIgnoreCase("Selesai")) {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_badge_blue);
            holder.tvStatus.setTextColor(Color.parseColor("#1565C0"));
        }
    }

    @Override
    public int getItemCount() { return sewaList.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMobil, tvDetail, tvJam, tvStatus;
        ImageView ivMobil;

        public ViewHolder(@NonNull View view) {
            super(view);
            // Menghubungkan variabel dengan ID yang ada di XML item_sewa_terbaru.xml
            tvMobil = view.findViewById(R.id.tvNamaMobil);
            tvDetail = view.findViewById(R.id.tvDetailSewa);
            tvJam = view.findViewById(R.id.tvJamSewa);
            tvStatus = view.findViewById(R.id.tvStatusSewa);
            ivMobil = view.findViewById(R.id.imgCar);
        }
    }
}