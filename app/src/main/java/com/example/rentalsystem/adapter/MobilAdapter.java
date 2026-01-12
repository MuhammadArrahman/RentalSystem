package com.example.rentalsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.R;
import com.example.rentalsystem.model.MobilModel;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class MobilAdapter extends RecyclerView.Adapter<MobilAdapter.ViewHolder> {

    private List<MobilModel> mobilList;
    private List<String> keyList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(MobilModel mobil, String key);
    }

    public MobilAdapter(List<MobilModel> mobilList, List<String> keyList, OnItemClickListener listener) {
        this.mobilList = mobilList;
        this.keyList = keyList;
        this.listener = listener;
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
        String key = keyList.get(position);

        holder.tvMerk.setText(mobil.getMerk());
        holder.tvTipe.setText(mobil.getTipe());
        holder.tvPlat.setText(mobil.getPlat());
        holder.tvHarga.setText(mobil.getHarga());
        holder.tvStatus.setText(mobil.getStatus());

        holder.btnBooking.setOnClickListener(v -> listener.onItemClick(mobil, key));
    }

    @Override
    public int getItemCount() {
        return mobilList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMerk, tvTipe, tvPlat, tvHarga, tvStatus;
        MaterialButton btnBooking;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMerk = itemView.findViewById(R.id.tvMerk);
            tvTipe = itemView.findViewById(R.id.tvTipe);
            tvPlat = itemView.findViewById(R.id.tvPlat);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            btnBooking = itemView.findViewById(R.id.btnBooking);
        }
    }
}
