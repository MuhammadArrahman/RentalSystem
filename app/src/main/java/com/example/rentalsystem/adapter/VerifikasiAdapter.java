package com.example.rentalsystem.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.R;
import com.example.rentalsystem.VerikasiDetailActivity;
import com.example.rentalsystem.model.VerifikasiModel;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class VerifikasiAdapter extends RecyclerView.Adapter<VerifikasiAdapter.ViewHolder> {

    private final List<VerifikasiModel> list;
    private final Context context;

    public VerifikasiAdapter(Context context, List<VerifikasiModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_verifikasi, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VerifikasiModel item = list.get(position);

        holder.tvNama.setText(item.getNama());
        holder.tvNik.setText("NIK: " + item.getNik());
        holder.tvWaktu.setText(item.getWaktu());
        holder.ivKtp.setImageResource(item.getFotoKtp());

        // ✅ PINDAH KE HALAMAN DETAIL
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, VerikasiDetailActivity.class);
            intent.putExtra("nama", item.getNama());
            intent.putExtra("nik", item.getNik());
            intent.putExtra("tgl_lahir", item.getTglLahir());
            intent.putExtra("status", item.getStatusKawin());
            intent.putExtra("foto", item.getFotoKtp());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvNik, tvWaktu;
        ShapeableImageView ivKtp;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNamaUser);
            tvNik = itemView.findViewById(R.id.tvNikUser);
            tvWaktu = itemView.findViewById(R.id.tvWaktu);
            ivKtp = itemView.findViewById(R.id.ivKtp);
        }
    }
}
