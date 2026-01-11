package com.example.rentalsystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentalsystem.R;
import com.example.rentalsystem.model.VerifikasiModel;

import java.util.List;

public class VerifikasiAdapter
        extends RecyclerView.Adapter<VerifikasiAdapter.ViewHolder> {

    private final Context context;
    private final List<VerifikasiModel> list;

    public VerifikasiAdapter(Context context, List<VerifikasiModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_verifikasi_ktp, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder, int position) {

        VerifikasiModel model = list.get(position);

        holder.tvNamaUser.setText(model.getNama());
        holder.tvNikUser.setText("NIK: " + model.getNik());
        holder.tvWaktu.setText(model.getWaktu());
        holder.tvTglLahir.setText(model.getTglLahir());
        holder.tvStatusKawin.setText(model.getStatusKawin());
        holder.ivKtp.setImageResource(model.getFotoKtp());

        // OPTIONAL CLICK
        holder.btnSetujui.setOnClickListener(v -> {
            // TODO: logic setujui
        });

        holder.btnTolak.setOnClickListener(v -> {
            // TODO: logic tolak
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivUser, ivKtp;
        TextView tvNamaUser, tvNikUser, tvWaktu,
                tvTglLahir, tvStatusKawin;
        Button btnTolak, btnSetujui;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivUser        = itemView.findViewById(R.id.ivUser);
            ivKtp         = itemView.findViewById(R.id.ivKtp);

            tvNamaUser    = itemView.findViewById(R.id.tvNamaUser);
            tvNikUser     = itemView.findViewById(R.id.tvNikUser);
            tvWaktu       = itemView.findViewById(R.id.tvWaktu);
            tvTglLahir    = itemView.findViewById(R.id.tvTglLahir);
            tvStatusKawin = itemView.findViewById(R.id.tvStatusKawin);

            btnTolak      = itemView.findViewById(R.id.btnTolak);
            btnSetujui    = itemView.findViewById(R.id.btnSetujui);
        }
    }
}
