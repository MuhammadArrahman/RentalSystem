package com.example.rentalsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.R;
import com.example.rentalsystem.model.NotifikasiModel; // Pastikan ini diimport
import java.util.List; // Tambahkan import List

public class NotifikasiAdapter extends RecyclerView.Adapter<NotifikasiAdapter.ViewHolder> {
    private List<NotifikasiModel> list;

    public NotifikasiAdapter(List<NotifikasiModel> list) { this.list = list; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // R.layout.item_notifikasi harus ada di folder res/layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notifikasi, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotifikasiModel item = list.get(position);
        holder.tvJudul.setText(item.getJudul());
        holder.tvIsi.setText(item.getIsi());
        holder.tvWaktu.setText(item.getWaktu());
        holder.ivIcon.setImageResource(item.getIconRes());
    }

    @Override
    public int getItemCount() { return list != null ? list.size() : 0; }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvJudul, tvIsi, tvWaktu;
        ImageView ivIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // ID ini harus ada di file item_notifikasi.xml
            tvJudul = itemView.findViewById(R.id.tvJudulNotif);
            tvIsi = itemView.findViewById(R.id.tvIsiNotif);
            tvWaktu = itemView.findViewById(R.id.tvWaktuNotif);
            ivIcon = itemView.findViewById(R.id.ivIconNotif);
        }
    }
}