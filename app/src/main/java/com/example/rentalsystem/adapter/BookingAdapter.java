package com.example.rentalsystem.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rentalsystem.R;
import com.example.rentalsystem.model.BookingModel;
import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {

    private List<BookingModel> bookingList;

    public BookingAdapter(List<BookingModel> bookingList) {
        this.bookingList = bookingList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Pastikan nama layout item Anda adalah item_booking.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_booking, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BookingModel item = bookingList.get(position);

        // Set Data Text
        holder.tvNamaUser.setText(item.getNamaUser());
        holder.tvBookingId.setText(item.getBookingId());
        holder.tvNamaMobil.setText(item.getNamaMobil());
        holder.tvPlatWarna.setText(item.getPlatWarna());
        holder.tvTanggal.setText(item.getTanggal());
        holder.tvDurasi.setText("Durasi Sewa: " + item.getDurasi());
        holder.tvHargaTotal.setText(item.getHarga());
        holder.tvStatusBadge.setText(item.getStatus());

        // LOGIKA DINAMIS BERDASARKAN STATUS
        String status = item.getStatus().toLowerCase();

        if (status.contains("pending")) {
            // Tampilan untuk Tab Pending
            holder.tvStatusBadge.setBackgroundResource(R.drawable.bg_status_pending); // Peach
            holder.tvStatusBadge.setTextColor(Color.parseColor("#B54708"));
            holder.layoutButtons.setVisibility(View.VISIBLE);
            holder.btnKiri.setText("Tolak");
            holder.btnKanan.setText("Konfirmasi");

        } else if (status.contains("sewa") || status.contains("berjalan")) {
            // Tampilan untuk Tab Berjalan (Siti Aminah)
            holder.tvStatusBadge.setBackgroundResource(R.drawable.bg_status_disewa); // Biru muda
            holder.tvStatusBadge.setTextColor(Color.parseColor("#175CD3"));
            holder.layoutButtons.setVisibility(View.VISIBLE);
            holder.btnKiri.setText("Hubungi");
            holder.btnKanan.setText("Selesai");
            // Ganti warna tombol kanan jadi Hijau seperti di gambar
            holder.btnKanan.setBackgroundResource(R.drawable.bg_btn_green);

        } else if (status.contains("selesai")) {
            // Tampilan untuk Tab Selesai (Andi Pratama)
            holder.tvStatusBadge.setBackgroundResource(R.drawable.bg_status_tersedia); // Hijau muda
            holder.tvStatusBadge.setTextColor(Color.parseColor("#12B76A"));

            // Di gambar, tombol hilang berganti jadi tombol "Lihat Detail" lebar
            holder.btnKiri.setVisibility(View.GONE);
            holder.btnKanan.setText("Lihat Detail");
            holder.btnKanan.setBackgroundResource(R.drawable.bg_btn_gray); // Abu-abu terang
            holder.btnKanan.setTextColor(Color.BLACK);
        }
    }

    @Override
    public int getItemCount() {
        return bookingList.size();
    }

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