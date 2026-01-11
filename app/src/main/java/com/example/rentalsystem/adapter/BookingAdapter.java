package com.example.rentalsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rentalsystem.R;
import com.example.rentalsystem.model.BookingModel;
import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {
    private List<BookingModel> list;

    public BookingAdapter(List<BookingModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Layout item_booking_card adalah layout kecil untuk baris list
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_booking, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BookingModel item = list.get(position);
        holder.tvNama.setText(item.getNamaUser());
        holder.tvId.setText(item.getBookingId());
        holder.tvMobil.setText(item.getNamaMobil());
        holder.tvHarga.setText(item.getHarga());
        // Tambahkan pengesetan view lainnya di sini...
    }

    @Override
    public int getItemCount() { return list.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvId, tvMobil, tvHarga;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNamaUser);
            tvId = itemView.findViewById(R.id.tvBookingId);
            tvMobil = itemView.findViewById(R.id.tvNamaMobil);
            tvHarga = itemView.findViewById(R.id.tvHargaTotal);
        }
    }
}