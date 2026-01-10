package com.example.rentalsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rentalsystem.R;
import com.example.rentalsystem.model.DashboardModel;
import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {
    private List<DashboardModel> list;

    public DashboardAdapter(List<DashboardModel> list) { this.list = list; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DashboardModel item = list.get(position);
        holder.tvNama.setText(item.getNama());
        holder.tvSpek.setText(item.getTransmisi() + " • " + item.getFitur());
        holder.tvHarga.setText(item.getHarga());
        holder.ivMobil.setImageResource(item.getGambarRes());
    }

    @Override
    public int getItemCount() { return list.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvSpek, tvHarga;
        ImageView ivMobil;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNamaDashboard);
            tvSpek = itemView.findViewById(R.id.tvSpekDashboard);
            tvHarga = itemView.findViewById(R.id.tvHargaDashboard);
            ivMobil = itemView.findViewById(R.id.ivMobilDashboard);
        }
    }
}