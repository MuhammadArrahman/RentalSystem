package com.example.rentalsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.R;
import com.example.rentalsystem.model.BookingModel;

import java.util.List;

public class AdapterBooking extends RecyclerView.Adapter<AdapterBooking.ViewHolder> {
    private List<BookingModel> list;

    public AdapterBooking(List<BookingModel> list) { this.list = list; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_booking, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BookingModel item = list.get(position);
        holder.tvNama.setText(item.getNama());
        holder.tvHarga.setText(item.getHarga());
        holder.tvKategori.setText(item.getKategori());
        holder.tvKursi.setText(item.getKursi());
        holder.tvTransmisi.setText(item.getTransmisi());
        holder.tvBbm.setText(item.getBbm());
        holder.ivMobil.setImageResource(item.getGambarRes());
    }

    @Override
    public int getItemCount() { return list.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvHarga, tvKategori, tvKursi, tvTransmisi, tvBbm;
        ImageView ivMobil;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNamaBooking);
            tvHarga = itemView.findViewById(R.id.tvHargaBooking);
            tvKategori = itemView.findViewById(R.id.tvKategori);
            tvKursi = itemView.findViewById(R.id.tvKursi);
            tvTransmisi = itemView.findViewById(R.id.tvTransmisi);
            tvBbm = itemView.findViewById(R.id.tvBbm);
            ivMobil = itemView.findViewById(R.id.ivMobilBooking);
        }
    }
}