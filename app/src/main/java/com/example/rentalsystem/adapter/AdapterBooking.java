package com.example.rentalsystem.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rentalsystem.R;
import com.example.rentalsystem.model.BookingModel;
import java.util.List;

public class AdapterBooking extends RecyclerView.Adapter<AdapterBooking.ViewHolder> {
    private List<BookingModel> list;

    public AdapterBooking(List<BookingModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_booking, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BookingModel item = list.get(position);

        holder.tvNamaUser.setText(item.getNamaUser());
        holder.tvBookingId.setText(item.getBookingId());
        holder.tvNamaMobil.setText(item.getNamaMobil());
        holder.tvPlatWarna.setText(item.getPlatWarna());
        holder.tvTanggal.setText(item.getTanggal());
        holder.tvDurasi.setText(item.getDurasi());
        holder.tvHargaTotal.setText(item.getHarga());
        holder.tvStatusBadge.setText(item.getStatus());

        // Logika perubahan warna status (Opsional)
        if (item.getStatus().equalsIgnoreCase("Selesai")) {
            holder.tvStatusBadge.setTextColor(Color.parseColor("#12B76A"));
            holder.layoutButtons.setVisibility(View.GONE);
        } else {
            holder.tvStatusBadge.setTextColor(Color.parseColor("#B54708"));
            holder.layoutButtons.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() { return list.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaUser, tvBookingId, tvStatusBadge, tvNamaMobil, tvPlatWarna, tvTanggal, tvDurasi, tvHargaTotal;
        Button btnKiri, btnKanan;
        View layoutButtons;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaUser = itemView.findViewById(R.id.tvNamaUser);
            tvBookingId = itemView.findViewById(R.id.tvBookingId);
            tvStatusBadge = itemView.findViewById(R.id.tvStatusBadge);
            tvNamaMobil = itemView.findViewById(R.id.tvNamaMobil);
            tvPlatWarna = itemView.findViewById(R.id.tvPlatWarna);
            tvTanggal = itemView.findViewById(R.id.tvTanggal);
            tvDurasi = itemView.findViewById(R.id.tvDurasi);
            tvHargaTotal = itemView.findViewById(R.id.tvHargaTotal);
            btnKiri = itemView.findViewById(R.id.btnKiri);
            btnKanan = itemView.findViewById(R.id.btnKanan);
            layoutButtons = itemView.findViewById(R.id.layoutButtons);
        }
    }
}