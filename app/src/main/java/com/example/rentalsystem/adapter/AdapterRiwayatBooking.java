package com.example.rentalsystem.adapter;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.R;
import com.example.rentalsystem.model.RiwayatBookingModel;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class AdapterRiwayatBooking
        extends RecyclerView.Adapter<AdapterRiwayatBooking.ViewHolder> {

    private List<RiwayatBookingModel> listRiwayat;
    private OnRiwayatClickListener listener;

    // 🔹 INTERFACE CLICK
    public interface OnRiwayatClickListener {
        void onItemClick(RiwayatBookingModel model);
        void onActionClick(RiwayatBookingModel model);
    }

    // 🔹 CONSTRUCTOR
    public AdapterRiwayatBooking(List<RiwayatBookingModel> listRiwayat, OnRiwayatClickListener selesai) {
        this.listRiwayat = listRiwayat;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_riwayat_booking, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder, int position) {

        RiwayatBookingModel item = listRiwayat.get(position);

        holder.tvNama.setText(item.getNama());
        holder.tvTanggal.setText(item.getTanggal());
        holder.tvHarga.setText(item.getHarga());
        holder.tvStatus.setText(item.getStatus());
        holder.tvStatusBayar.setText(item.getStatusBayar());
        holder.imgMobil.setImageResource(item.getGambarRes());

        // 🎨 LOGIKA TOMBOL DINAMIS
        if (item.getStatus().equalsIgnoreCase("SELESAI")) {
            holder.btnAction.setText("Sewa Lagi");
            holder.btnAction.setBackgroundTintList(
                    ColorStateList.valueOf(Color.parseColor("#2970FF")));
            holder.btnAction.setTextColor(Color.WHITE);
        } else {
            holder.btnAction.setText("Lihat E-Receipt");
            holder.btnAction.setBackgroundTintList(
                    ColorStateList.valueOf(Color.parseColor("#F5F7FA")));
            holder.btnAction.setTextColor(Color.BLACK);
        }

        // 🔥 CLICK CARD
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(item);
            }
        });

        // 🔥 CLICK BUTTON
        holder.btnAction.setOnClickListener(v -> {
            if (listener != null) {
                listener.onActionClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listRiwayat.size();
    }

    // 🔹 VIEWHOLDER
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvTanggal, tvHarga, tvStatus, tvStatusBayar;
        ImageView imgMobil;
        MaterialButton btnAction;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNamaRiwayat);
            tvTanggal = itemView.findViewById(R.id.tvTanggalRiwayat);
            tvHarga = itemView.findViewById(R.id.tvHargaRiwayat);
            tvStatus = itemView.findViewById(R.id.tvStatusLabel);
            tvStatusBayar = itemView.findViewById(R.id.tvStatusBayarLabel);
            imgMobil = itemView.findViewById(R.id.imgMobilRiwayat);
            btnAction = itemView.findViewById(R.id.btnAction);
        }
    }
}
