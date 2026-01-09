package com.example.rentalsystem.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rentalsystem.R;
import com.example.rentalsystem.model.VerifikasiModel;
import java.util.List;

public class VerifikasiAdapter extends RecyclerView.Adapter<VerifikasiAdapter.ViewHolder> {
    private List<VerifikasiModel> list;

    public VerifikasiAdapter(List<VerifikasiModel> list) { this.list = list; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_verifikasi_ktp, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VerifikasiModel item = list.get(position);
        holder.tvNama.setText(item.getNama());
        holder.tvNik.setText("NIK: " + item.getNik());
        holder.tvWaktu.setText(item.getWaktu());
        holder.tvTgl.setText(item.getTglLahir());
        holder.tvKawin.setText(item.getStatusKawin());
        holder.ivKtp.setImageResource(item.getFotoKtp());
    }

    @Override
    public int getItemCount() { return list.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvNik, tvWaktu, tvTgl, tvKawin;
        ImageView ivKtp;
        public ViewHolder(@NonNull View v) {
            super(v);
            tvNama = v.findViewById(R.id.tvNamaUser);
            tvNik = v.findViewById(R.id.tvNikUser);
            tvWaktu = v.findViewById(R.id.tvWaktu);
            tvTgl = v.findViewById(R.id.tvTglLahir);
            tvKawin = v.findViewById(R.id.tvStatusKawin);
            ivKtp = v.findViewById(R.id.ivKtp);
        }
    }
}